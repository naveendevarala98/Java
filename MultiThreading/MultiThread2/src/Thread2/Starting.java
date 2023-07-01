package Thread2;

public class Starting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread started");
		/*
		 * Thread1 thread = new Thread1("Thread1"); //thread.setDaemon(true);
		 * thread.start();
		 */
		
		//runnable so instance needs to be based
		/*
		 * Thread thread2 = new Thread(()->{ for(int i=0;i<5;i++) {
		 * System.out.println("Inside "+Thread.currentThread()+i); } }, "Thread2");
		 * thread2.start();
		 */
		
		System.out.println("Main thread executed");
		
		
		//Synchronization concept - pusher and poper
	/*	Stack a =new Stack(5);
		
		new Thread(()->{
			int counter =0;
			while(++counter<10) {
				System.out.println("Pushed :"+a.push(100));
			}
			
		},"Pusher").start();
		new Thread(()->{
			int counter =0;
			while(++counter<10) {
				System.out.println("poped :"+a.pop());
			}
			
		},"Poper").start();*/
		
		//join
		Thread thread = new Thread(()-> {
			System.out.println("Threaf join");	
		},"OurThread");
		
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("main thread join");
	}
		
		

}
