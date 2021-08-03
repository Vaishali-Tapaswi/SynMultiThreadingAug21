package sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// Problem Statement
class Lab1Helper implements Runnable {
	private final ReentrantLock lock;
	private List<String> list;

	public Lab1Helper(List<String> list, ReentrantLock lock) {
		this.list = list;
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("Queue" + lock.getQueueLength());
			lock.lock();
			list.add(Thread.currentThread().getName() + "" + i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			lock.unlock();
		}

	}
}

public class Lab1 {
	public static void main(String[] args) throws InterruptedException {
		final ReentrantLock lock = new ReentrantLock();
		ThreadGroup group = new ThreadGroup("work");
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			Thread t1 = new Thread(group, new Lab1Helper(list, lock));
			t1.start();
		}
		int count = group.activeCount();
		System.out.println("Threads Started " + count);

		while (group.activeCount() > 0) {
			System.out.println("Current ActiveCount is " + count + " and list size is " + list.size());
			Thread.sleep(100);
		}
		System.out.println("Current ActiveCount is " + count + " and list size is " + list.size());
	}
}
