
class Hi extends Thread {
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
class Hello extends Thread {
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
public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hello ob1 = new Hello();
		Hi ob2 = new Hi();
		ob1.start();
		ob2.start();
	}

}
