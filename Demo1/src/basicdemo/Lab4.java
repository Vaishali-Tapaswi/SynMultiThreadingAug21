package basicdemo;

import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		System.out.println("Current Code in main with thread " + Thread.currentThread().getName());
		Runnable lab4helper = () -> {
			System.out.println("Current Thread is " + Thread.currentThread().getName());
			for (int i = 0; i < 900; i++) {
				System.out.print(i + "\t");
			}
		};
		Thread t1 = new Thread(lab4helper);
		t1.start();
	}
}
