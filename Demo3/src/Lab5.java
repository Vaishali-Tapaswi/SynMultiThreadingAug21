import java.util.Scanner;

class DepositThread implements Runnable {
	private Bank bank;

	public DepositThread(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ", current i = " + i + ", current balance = "
					+ bank.getBalance());
			synchronized (bank) {
				this.bank.setBalance(this.bank.getBalance() + 1);
				if (this.bank.getBalance() > 1) {
					bank.notify();
					System.out.println("Notifying Bank..");
				}
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class WithrawThread implements Runnable {
	private Bank bank;

	public WithrawThread(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + ", current i = " + i + ", current balance = "
						+ bank.getBalance());
				synchronized (bank) {
					if (bank.getBalance() <= 0) {
						System.out.println("Going to invoke wait now............");
						bank.wait(10000);
						// Thread.sleep(10);
					}
					this.bank.setBalance(this.bank.getBalance() - 1);
				}
				Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Bank {
	private String acno;
	private int balance;

	public Bank(String acno, int balance) {
		this.acno = acno;
		this.balance = balance;
	}

	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank [acno=" + acno + ", balance=" + balance + "]";
	}
}

public class Lab5 {
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		Bank bank = new Bank("Acc1", 0);
		ThreadGroup account = new ThreadGroup("account");
		Thread deposit = new Thread(account, new DepositThread(bank));
		deposit.setName("deposit");
		Thread widraw = new Thread(account, new WithrawThread(bank));
		widraw.setName("widraw");
		deposit.start();
		widraw.start();

		while (account.activeCount() > 0) {
			// System.out.println("Main Method = Balance: " +bank.getBalance());
			Thread.sleep(100);
		}
		System.out.println("Final Balance is   " + bank.getBalance());

		Thread.sleep(30000);

	}
}
