package Thread;

class Count{
	int count;
	public synchronized void increment() { //only one thread execute at one time
		count++;
	}
}
public class SynchronizationExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Count c = new Count();
		
		Thread t1=new Thread(new Runnable()
		{
			public void run() {
				for(int i=0;i<1000;i++) {
					c.increment();
					
				}
			}
		});
		
		//Funtional interface - lambda expresssion
		Thread t2 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				c.increment();
			}
		},"Hello thread");
		
		
		t1.start();
		t2.start();
		
		//waits till t1 and t2 completes
		t1.join();
		t2.join();
		
		System.out.println("count "+c.count);

	}



}
