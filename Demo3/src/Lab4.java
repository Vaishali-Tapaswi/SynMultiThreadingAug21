import java.util.Scanner;

class Lab4Helper implements Runnable{
	private String str1;
	private String str2;
	
	
	
	public Lab4Helper(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
	}



	@Override
	public void run() {
		try {
		String name  = Thread.currentThread().getName();
		System.out.println("Run invoked for " + name );
		synchronized (str1) {
				System.out.println(name + "Locked Str1, Take a dump ");
				Thread.sleep(10000);
				synchronized (str2) {
					System.out.println(name + "Locked Str1 already, now have taken lock on str2, Take a dump ");
					Thread.sleep(10000);
				}
				System.out.println(name + " releasing str2");
		}	
		System.out.println(name + " releasing str1");
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
public class Lab4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();

		String str1 = "Str1";
		String str2 = "Str2";
		Thread t1 = new Thread(new Lab4Helper(str1, str2));
		Thread t2 = new Thread(new Lab4Helper(str1, str2));
		System.out.println("Starting Threads t1 and t2");
		t1.start();
		t2.start();
	}
}
