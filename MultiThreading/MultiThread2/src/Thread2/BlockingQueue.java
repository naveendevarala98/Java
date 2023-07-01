package Thread2;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	
	private Queue<Integer>q;
	private int capacity;
	
	public BlockingQueue(int cap) {
		q=new LinkedList<>();
		capacity=cap;
	}
	
	public boolean add(int item) {
		synchronized(q) {
			while(q.size()==capacity) { // while loop is used to check the capacity if multiple threads are freed to run after waiting
				try {
					q.wait();//adder1, adder 2
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			q.add(item);
			q.notifyAll();
			return true;
		}
	}
	
	public int remove() {
		synchronized(q) {
			while(q.size()==0) {
				try {
					q.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int element = q.poll();
			return element;
		}
	}

}
