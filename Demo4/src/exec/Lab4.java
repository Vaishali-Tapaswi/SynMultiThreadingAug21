package exec;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Lab4Helper implements Callable<Integer>{
	private int no1;
	private int no2;
	
	public Lab4Helper(int no1, int no2) {
		this.no1 = no1;
		this.no2 = no2;
	}
	@Override
	public Integer call() throws Exception {
		System.out.println("Call invoked in Thread " + Thread.currentThread().getName() + " with " + no1 + ", " + no2);
		try{Thread.sleep(400);}catch(Exception e) {}
		return no1+no2;
	}
}

public class Lab4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Current Code in main with  " + Thread.currentThread().getName());
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer>[] arr = new Future[10];
		for (int  i=1;i<=10;i++) {
			arr[i-1] = service.submit(new Lab4Helper(i+1, i*2));
		}
		
		System.out.println(".....");
		for (int  i=1;i<=10;i++) { 
			System.out.println("Ans = " + arr[i-1].get());
		}
		
		//service.shutdown();
	}

}
