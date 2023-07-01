package Thread2;

/*
 * Here we are implementing runnable, so instance of this needs to be passed to thread class, 
 * run method of that thread class will be executed
 * */
public class Thread2Run implements Runnable {
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Inside "+Thread.currentThread()+i);
		}
	}

}
