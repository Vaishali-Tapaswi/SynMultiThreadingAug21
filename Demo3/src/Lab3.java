import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 1 option  - Synchronized
class Lab3Helper implements Runnable {
	private List<String> list;

	public Lab3Helper(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
				list.add(Thread.currentThread().getName() + "" + i);
		}
	}
}

public class Lab3 {
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();

		ThreadGroup group = new ThreadGroup("work");
//		List<String> list = new ArrayList<String>();
		List<String> list = 	Collections.synchronizedList(new ArrayList<String>());
		for (int i = 1; i <= 3; i++) {
			Thread t1 = new Thread(group, new Lab3Helper(list));
			t1.start();
		}
		int count = group.activeCount();
		System.out.println("Threads Started " + count);

		while (group.activeCount() > 0) {
			System.out.println("Current ActiveCount is " + count + " and list size is " + list.size());
			Thread.sleep(1);
		}
		System.out.println("Current ActiveCount is " + count + " and list size is " + list.size());
	}
}
