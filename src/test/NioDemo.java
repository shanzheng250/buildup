package test;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sun.corba.se.impl.ior.ByteBuffer;

public class NioDemo {
	
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	
	@SuppressWarnings({ "unused", "resource" })
	private void BioDemo() throws Exception {
		ServerSocket serversocket = null;
		serversocket = new ServerSocket(8081);
		
		Socket socket = null;
		
		while(true) {
			socket = serversocket.accept();
			
			//TODO 这里应该使用线程来进行处理
			ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
			
			pool.submit(() ->{
				
//				BufferedReader br = null;
//				try {
//					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				String content = "";
//				
//				try {
//					if((content = br.readLine()) != null) {
//						System.out.println(content);
//					}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			});
			
			
		}
	}
	
	
	
	private void NioDemo() throws Exception {
		
		// 打开seletor
		Selector selector = Selector.open();
		
		//打开通道
		ServerSocketChannel channel = ServerSocketChannel.open();
		
		// 设置为异步编码
		channel.configureBlocking(false);
		
		//绑定
		channel.bind(new InetSocketAddress(8081));
		
		
		channel.register(selector, SelectionKey.OP_READ);
		
		
		while(true) {
			
			selector.select(1000);
			Set<SelectionKey> key = selector.selectedKeys();
			
			Iterator<SelectionKey>  selectkey =  key.iterator();
			
			SelectionKey s ;
			
			if(selectkey.hasNext()) {
				
				s = selectkey.next();
				
				if(s.isValid()) {
					
					if(s.isReadable()) {
						
						System.out.println("可读写的内容...");
						
						SocketChannel channel2 = (SocketChannel) s.channel();
						
						java.nio.ByteBuffer bf = java.nio.ByteBuffer.allocateDirect(1024);
						
						int readbytes =   channel2.read(bf);
						
						while(readbytes!= 0 ) {
							
							
							
						}
						
						
					}
					
				}
				
				
			}
			
		}
		
	}
	
	
	
	
	
	
}
