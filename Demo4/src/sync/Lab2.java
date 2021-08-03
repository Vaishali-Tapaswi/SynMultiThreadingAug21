package sync;

import java.util.concurrent.CyclicBarrier;

class Lab2Helper implements Runnable{
	private CyclicBarrier barrier;
	
	public Lab2Helper(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
		System.out.println(Thread.currentThread().getName() + "  started from location1 to l1");
		Thread.sleep((long)(Math.random()*1000));
		barrier.await();
		System.out.println(Thread.currentThread().getName() + "  start from l1 to l2");
		Thread.sleep((long)(Math.random()*1000));
		barrier.await();
		System.out.println(Thread.currentThread().getName() + "  start from l2 to final location2");
	    Thread.sleep((long)(Math.random()*1000));
		System.out.println(Thread.currentThread().getName() + " Completed and Reached location2");
		}catch(Exception e ) {}
	}
}
public class Lab2 {
public static void main(String[] args) {
		final CyclicBarrier barrier = new CyclicBarrier(3);
		Thread t1 = new Thread(new Lab2Helper(barrier));
		t1.setName("Car1");
		Thread t2 = new Thread(new Lab2Helper(barrier));
		t2.setName("Car2");
		Thread t3 = new Thread(new Lab2Helper(barrier));
		t3.setName("Car3");
		t1.start();
		t2.start();
		t3.start();
}
}
