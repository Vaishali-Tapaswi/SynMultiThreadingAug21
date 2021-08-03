package exec;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab1Helper implements Runnable{

	@Override
	public void run() {
		System.out.println("Current Thread is " + Thread.currentThread().getName());
		for (int i = 0; i< 10;i++) {
			System.out.print(i +"\t");
		}
		System.out.println();
	}
}
public class Lab1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		System.out.println("Current Code in main with thread " + Thread.currentThread().getName());
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Lab1Helper());
		service.execute(new Lab1Helper());
		service.execute(new Lab1Helper());
		service.shutdown();
	}

}
