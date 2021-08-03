package threadinteraction;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab2Helper implements Runnable {

	CountDownLatch latch;

	public Lab2Helper(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting with " + Thread.currentThread().getName());
	
		for (int i = 1; i <= 10; i++) {
			try { 				Thread.sleep((long) (Math.random() * 1000));			} catch (InterruptedException e) {		}
		}
		latch.countDown();
		System.out.println("Ending  " + Thread.currentThread().getName());
	}
}
public class Lab2 {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number ");
		int num = scanner.nextInt();
		System.out.println(" count of latch = " + num/2);
		ExecutorService service = Executors.newFixedThreadPool(num);
		CountDownLatch latch =new CountDownLatch(num/2);
		for(int i = 0;i< num;i++)
			service.execute(new Lab2Helper(latch));
		
		latch.await();
		System.out.println("50 % work is successfully done !!!");
		service.shutdown();
	}
}
