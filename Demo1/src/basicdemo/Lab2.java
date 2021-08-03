package basicdemo;

import java.util.Scanner;

class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println("Current Thread is " + this.getName());
		for (int i = 0; i< 900;i++) {
			System.out.print(i +"\t");
		}
	}
}
public class Lab2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		System.out.println("Current Code in main with thread " + Thread.currentThread().getName());
			Thread t1 = new Thread1();
			t1.start();

	}

}
