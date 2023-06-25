package Thread;

public class LambdaRunnableExample {

	public static void main(String[] args) {
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
		
		Thread t1=new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("Hi");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
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
		});
		t1.start();
		try {Thread.sleep(10);} catch(Exception e) {}
		t2.start();

	}

}
