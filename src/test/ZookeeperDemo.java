package test;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookeeperDemo {
	
	public static String ZOOKEEPERIP = "172.16.114.3:2181";
	
	public static String ROOT = "/ievent";
	
	public static void main(String[] args) throws Exception {
		
		CountDownLatch latch = new CountDownLatch(1);
		
		ZooKeeper zoo = new ZooKeeper(ZOOKEEPERIP, 4000,(WatchedEvent e)->{
			System.out.println("进行监听...");
			latch.countDown();
		}) ;
		
		latch.await();
		
//		String s = zoo.create(ROOT, "0".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//		
//		System.out.println(s);
		
		
		System.out.println(new String(zoo.getData(ROOT, false, null)));
		
		Stat s = zoo.exists(ROOT, false);
		
		System.out.println("zxid为" + s.getCzxid() + " version为"+ s.getVersion());
	}

}
