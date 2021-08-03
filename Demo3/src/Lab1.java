import java.util.ArrayList;
import java.util.List;
// Problem Statement
class Lab1Helper implements Runnable {
	private List<String> list;

	public Lab1Helper(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			list.add(Thread.currentThread().getName() + "" + i);
		}

	}
}

public class Lab1 {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup group = new ThreadGroup("work");
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			Thread t1 = new Thread(group, new Lab1Helper(list));
			t1.start();
		}
		int count = group.activeCount();
		System.out.println("Threads Started "+ count);
		
		while (group.activeCount() > 0) {
		//	if (count != group.activeCount()) {
				System.out.println("Current ActiveCount is " + count + " and list size is " + list.size());
		//	}
			Thread.sleep(1);
		}
		System.out.println("Current ActiveCount is " + count + " and list size is " + list.size());
	}
}
