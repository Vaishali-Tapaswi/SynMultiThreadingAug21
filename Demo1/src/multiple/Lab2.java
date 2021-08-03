package multiple;

import java.util.Scanner;

class Lab2Helper implements Runnable {
	static boolean flag = true;
	String str;

	public Lab2Helper(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
			if (flag == true) {
				System.out.println(str + i);
				Lab2.location = str;
				if (i == 10)
					flag = false;
			} else {
				break;
			}
		}
	}
}

public class Lab2 {
	static String location = "";

	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("Please enter a number to continue");
		 *  scanner.nextInt();
		 */
		Thread t1 = new Thread(new Lab2Helper("Shimla"));
		Thread t2 = new Thread(new Lab2Helper("Manali"));
		Thread t3 = new Thread(new Lab2Helper("Kulu"));
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your Choice of  Location = " + location);
	}
}
