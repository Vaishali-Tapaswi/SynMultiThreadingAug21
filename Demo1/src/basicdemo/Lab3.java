package basicdemo;

import java.util.Scanner;

class Lab3Helper implements Runnable{

	@Override
	public void run() {
		System.out.println("Current Thread is " + Thread.currentThread().getName());
		for (int i = 0; i< 900;i++) {
			System.out.print(i +"\t");
		}
	}
}
public class Lab3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		System.out.println("Current Code in main with thread " + Thread.currentThread().getName());
			Thread t1 = new Thread(new Lab3Helper());
			t1.setName("HelperThread");
			t1.start();
	}

}
