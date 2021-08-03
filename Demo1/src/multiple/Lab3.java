package multiple;

import java.util.Scanner;

class Lab3Helper implements Runnable {
	String str;

	public Lab3Helper(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100000; i++) {
			System.out.println(str + i);
		}
	}
}

public class Lab3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		Thread th = new Thread(new Lab3Helper("Hyd"));
		th.setName("Hyd");
		th.setPriority(Thread.MAX_PRIORITY);

		Thread t1 = new Thread(new Lab3Helper("Shimla"));
		t1.setName("Shimla");
		Thread t2 = new Thread(new Lab3Helper("Manali"));
		t2.setName("Manali");
		Thread t3 = new Thread(new Lab3Helper("Kulu"));
		t3.setName("Kulu");

		th.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
