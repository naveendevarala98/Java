package Thread2;

/*
 * Here new thread class has been created and we are overriding the run method
 * */
public class Thread1 extends Thread {
	
	public Thread1(String threadname) {
		super(threadname);
	}
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("inside: "+Thread.currentThread()+i);
		}
	}

}
