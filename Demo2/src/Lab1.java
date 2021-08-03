class Thread1 implements Runnable{
	@Override
	public void run() {
		System.out.println("Current Thread is " + Thread.currentThread().getName());
		for (int i = 0; i< 900;i++) {
			System.out.print(i +"\t");
		}
	}
}


public class Lab1 {

	public static void main(String[] args) {
			Thread t1 = new Thread(new Thread1());
	//		t1.setDaemon(true);
			t1.start();
			System.out.println("at the end of main....");
	}

}
