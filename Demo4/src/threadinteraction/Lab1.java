package threadinteraction;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab1Helper implements Runnable {
	String str;
	CountDownLatch latch;

	public Lab1Helper(String str, CountDownLatch latch) {
		this.str = str;
		this.latch = latch;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
			if (latch.getCount() > 0) {
				System.out.println(str + i);
				Lab1.location = str;
			} else {
				break;
			}
		}
		latch.countDown();
	}
}

public class Lab1 {
	static String location = "";

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		CountDownLatch latch =new CountDownLatch(1);
		service.execute(new Lab1Helper("Shimla",latch));
		service.execute(new Lab1Helper("Manali",latch));
		service.execute(new Lab1Helper("Kulu",latch));
		
		latch.await();
		System.out.println("Your Choice of  Location = " + location);
		service.shutdown();
	}
}
