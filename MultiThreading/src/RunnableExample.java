class A{
	
}
class Hi1 extends A implements Runnable {
	public void run() {
		
		for(int i=0;i<5;i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class Hello1 extends A implements Runnable {
	public void run() {
		
		for(int i=0;i<5;i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
public class RunnableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hello1 ob1 = new Hello1();
		Hi1 ob2 = new Hi1();
		
		Thread t1=new Thread(ob1);
		Thread t2 = new Thread(ob2);
		t1.start();
		try {Thread.sleep(10);} catch(Exception e) {}
		t2.start();
	}

}
