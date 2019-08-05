package test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class DispatcherDemo implements Watcher,Lock{
	
	public static String ZOOKEEPERIP = "172.16.114.3:2181";
	
	public static String ROOT = "/ievent";
	
	String current;
	
	String prenode;
	
	CountDownLatch countDownLatch = new CountDownLatch(1);
	
	ZooKeeper zoo = null ;

	public DispatcherDemo() {
		try {
			 zoo = new ZooKeeper(ZOOKEEPERIP, 4000, (e)->{
				countDownLatch.countDown();
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void lock() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		if(tryLock()) {
			System.out.println("获取锁成功");
		}
		
		Stat s;
		try {
			s = zoo.exists(ROOT+"/"+ prenode,true);
			
			if(s!=null) {
				System.out.println("等待前驱锁...");
				CountDownLatch countDownLatch = new CountDownLatch(1);
				countDownLatch.await();
				System.out.println("获取锁...");

			}
			
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public boolean tryLock() {
		try {
			// 进来的进程先创建有序节点
			current = zoo.create(ROOT+"/", "0".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			
//			Set<String> allSet = new TreeSet<>();
			
			List<String> str = zoo.getChildren(ROOT, false);
			
			Collections.sort(str, (s1,s2)->{
				if(Long.parseLong(s1) > Long.parseLong(s2)) {
					return 1;
				}else if(Long.parseLong(s1) < Long.parseLong(s2)){
					return -1;
				}
				return 0;
			});
			
			
			if(current.equals(str.get(0))) {
				return true;
			}

			int i = str.indexOf(current);
			
			prenode = str.get(i-1);
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public void lockInterruptibly() throws InterruptedException {
		
	}

	@Override
	public Condition newCondition() {
		return null;
	}

	

	@Override
	public boolean tryLock(long arg0, TimeUnit arg1) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		
	}

	@Override
	public void process(WatchedEvent arg0) {
		System.out.println("进行监听...");
//		latch.countDown();
	}
	
	
	
	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(10);

		
		for(int i=0;i<10;i++) {
			new Thread(()->{
				try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DispatcherDemo demo = new DispatcherDemo();
				demo.lock();
				
			},"Thread" + i).start();
			
			countDownLatch.countDown();
			
		}
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
		
	}
	

