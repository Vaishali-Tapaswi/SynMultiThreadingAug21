package exec;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Lab5Helper implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : "  + new Date());
		}
	}

public class Lab5 {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
//		service.schedule(new Lab5Helper(), 5, TimeUnit.SECONDS);
	//	service.scheduleAtFixedRate(new Lab5Helper(),5,1,TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(new Lab5Helper(),5,1,TimeUnit.SECONDS);
	}
}
