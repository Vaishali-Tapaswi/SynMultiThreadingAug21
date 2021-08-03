package exec;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab31Helper implements Runnable{
	@Override
	public void run() {
		String name =  Thread.currentThread().getName() + "  ";
		for (int i = 1; i< 9;i++) {
			System.out.print(name  + i +"\n");
		}
		System.out.println();
	}
}
class Lab32Helper implements Runnable{
	@Override
	public void run() {
		String name =  Thread.currentThread().getName() +"  " ;
		for (int i = 11; i< 19;i++) {
			System.out.print(name  + i +"\n");
		}
		System.out.println();
	}
}

public class Lab3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		System.out.println("Current Code in main with thread " + Thread.currentThread().getName());
		/*ExecutorService service = Executors.newCachedThreadPool();
		for (int i =0; i< 100;i++) {
			service.execute(new Lab31Helper()); 
			service.execute(new Lab32Helper()); 
			service.execute(new Lab31Helper()); 
			}
		*/
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new Lab31Helper());
		service.execute(new Lab31Helper());
		service.execute(new Lab31Helper());
		service.execute(new Lab31Helper());
		service.execute(new Lab31Helper());
		service.execute(new Lab31Helper());
		service.execute(new Lab31Helper());
		
		service.shutdown();
	}

}
