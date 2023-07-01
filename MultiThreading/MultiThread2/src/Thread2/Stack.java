package Thread2;

public class Stack {
	
	int[] a;
	int stackTop=0;
	//Object lock1,lock2;
	//Object lock;
	
	public Stack(int capactiy) {
		a=new int[capactiy];
		stackTop=-1;
	//	lock1=new Object();
	//	lock2=new Object();
	//	lock = new Object();
		
	}
	
	public boolean isEmpty() {
		return stackTop<0;
	}

	public boolean isFull() {
		return stackTop>=a.length-1;
	}
	
	public synchronized boolean push(int ele) {
	//	synchronized(lock){
		if(isFull()) return false;
		++stackTop;
		try {Thread.sleep(1000);}catch(Exception e) {}
		a[stackTop] = ele;
		return true;
		//}
	}
	
	public synchronized int pop() {
		//synchronized(lock){
		if(isEmpty()) return Integer.MIN_VALUE;
		int obj = a[stackTop];
		a[stackTop] = Integer.MIN_VALUE;
		try { Thread.sleep(1000);} catch(Exception e) {}
		stackTop --;
		return obj;
		//}
	}
}
