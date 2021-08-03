package multiple;

import java.util.Scanner;

class Lab1Helper implements Runnable{
	String str;
	public Lab1Helper(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		for(int i = 0;i< 9999999;i++) {
			//try { Thread.sleep(500); } catch (InterruptedException e) { }
			System.out.print(str);
		}
	}
}
public class Lab1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
	
		Thread t1 = new Thread(new Lab1Helper("-"));
		Thread t2 = new Thread(new Lab1Helper("+"));
		Thread t3 = new Thread(new Lab1Helper("x"));
		t1.start();
		// main + t1 -> time slicing
		t2.start();
		// main, t1, t2
		t3.start();
		// main, t1,t2, t3
	}
}
