package Thread;

public class LambdaRunnableExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//Anonymous class
		/*
		 * Runnable ob1 = new Runnable() { public void run() {
		 * 
		 * for(int i=0;i<5;i++) { System.out.println("Hello"); try { Thread.sleep(500);
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * } }; Runnable ob2 = new Runnable() { public void run() {
		 * 
		 * for(int i=0;i<5;i++) { System.out.println("Hello"); try { Thread.sleep(500);
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * } };
		 */
		
		//Funtional interface - lambda expresssion
		Thread t1=new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("Hi "+Thread.currentThread().getPriority());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"Hi Thread");
		
		Thread t2 = new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("Hello");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"Hello thread");
		
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		//set priority
		t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		try {Thread.sleep(10);} catch(Exception e) {}
		t2.start();
		
		//waits till t1 and t2 completes
		t1.join();
		t2.join();
		
		System.out.println(t1.isAlive());//checks whether thread is live or not
		
		System.out.println("bye");

	}

}
