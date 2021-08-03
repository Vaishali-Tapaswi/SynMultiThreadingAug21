package exec;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab21Helper implements Runnable{
	@Override
	public void run() {
		System.out.println("Current Thread is " + Thread.currentThread().getName());
		for (int i = 3000; i< 99999;i++) {
			System.out.print(i +"\t");
		}
		System.out.println();
	}
}
class Lab22Helper implements Runnable{
	@Override
	public void run() {
		System.out.println("Current Thread is " + Thread.currentThread().getName());
		for (int i = 1; i< 2000;i++) {
			System.out.print(i +"\t");
			if (i==1800) 
					throw new RuntimeException("Problem.................");
		}
		System.out.println();
	}
}

public class Lab2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		System.out.println("Current Code in main with thread " + Thread.currentThread().getName());
	//	ExecutorService service = Executors.newSingleThreadExecutor();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new Lab21Helper()); 
		service.execute(new Lab22Helper()); 
		service.execute(new Lab21Helper()); 
		
		service.shutdown();
	}

}
