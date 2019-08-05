package stackoverflow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口
 * @author shanz
 * @date 2018年9月17日
 */
public class Flowstack {
	
	private Queue<Integer> tempQueue;
	
	int temp = 0;

	public Flowstack() {
		tempQueue = new LinkedList();
	}
	
	
	public void getTableList(int len,int [] a) {
		temp = a[0];
		int max = temp;
		
		for(int i=0;i<len;i++) {
			
			if(a[i] > temp) {
				
				max = a[i];
			}
			
		}
		
		tempQueue.add(max);
		
		
		while(a.length - len +1 >0) {

			
		}
		
		
		
		
	}
	
	
	
	

}
