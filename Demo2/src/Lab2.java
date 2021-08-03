class Thread2Helper implements Runnable{
	@Override
	public void run() {
		System.out.println("Current Thread is " + Thread.currentThread().getName());
		for (int i = 0; i< 50;i++) {
			System.out.print(i +"\t");
			try{Thread.sleep((long) (Math.random() * 1000));}catch(Exception e) {}
		}
	}
}
public class Lab2 {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup g1 = new ThreadGroup("cars");
		Thread t1 = new Thread(g1,new Thread2Helper());
		t1.start();
		Thread t2 = new Thread(g1,new Thread2Helper());
		t2.start();
		Thread t3 = new Thread(g1,new Thread2Helper());
		t3.start();
		while(g1.activeCount() > 0)
		{
			Thread.sleep(1000);
			System.out.println("\n\nActive Threads in "+ g1.activeCount());
		}

	}

}
