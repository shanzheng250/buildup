package test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorDemo {

	public static String ZOOKEEPERIP = "172.16.114.3:2181";
	
	public static String ROOT = "/ievent";
	
	public static String TEST = "/test";

	
	public static void main(String[] args) {
		
		CuratorFramework creator = CuratorFrameworkFactory.newClient(ZOOKEEPERIP, new ExponentialBackoffRetry(1000, 10));
		
		creator.start();
		
		
		try {
			// 增加
			creator.create().forPath("/test", "1".getBytes());
			
			
			creator.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/test");
			
			
			creator.delete().forPath("/test");

			creator.getChildren();
			
			String data = new String(creator.getData().forPath(ROOT));
			
			System.out.println("根节点的内容为" + data);
			
			
			//-------------------------节点监听----------------------------
			// 只会监听创建和修改
			NodeCache cache = new NodeCache(creator, TEST);
			cache.getListenable().addListener(()->{
				
			});
			
			// 监听和修改
			TreeCache cache1 = new TreeCache(creator, TEST);
//			cache1.getListenable().addListener((framework,treeCacheEvent)->{
//				switch (TreeCacheEvent.Type.) {
//				case value:
//					
//					break;
//
//				default:
//					break;
//				}
//			});
			
			
			//-------------------------分布式锁----------------------------
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
