package fk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class MyRecursiveTask extends RecursiveTask<List<String>> {
	private List<String> inputlist;
	private Predicate<String> filter;

	public MyRecursiveTask(List<String> inputlist, Predicate<String> filter) {
		this.inputlist = inputlist;
		this.filter = filter;
	}

	private List<MyRecursiveTask> preparelist(List<String> inputlist, Predicate<String> filter) {

		List<MyRecursiveTask> list = new ArrayList<MyRecursiveTask>();
		MyRecursiveTask task1 = new MyRecursiveTask(inputlist.subList(0, inputlist.size() / 2), filter);
		MyRecursiveTask task2 = new MyRecursiveTask(inputlist.subList(inputlist.size() / 2, inputlist.size()), filter);
		list.add(task1);
		list.add(task2);

		return list;
	}

	@Override
	protected List<String> compute() {
		List<String> outputlist = new ArrayList<String>();
		System.out.println("in compute of MyRecursive Task with list size = " + inputlist.size());
		if (inputlist.size() > 50) {
			System.out.println(" better to break it into multiple threads....");
			List<MyRecursiveTask> helper = preparelist(inputlist, filter);
			for (MyRecursiveTask task : helper) {
				task.fork();
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			for (MyRecursiveTask task : helper) {
				outputlist.addAll(task.join());
			}
		} else {
			System.out.println("Filter it yourself");
			outputlist = inputlist.stream().filter(filter).collect(Collectors.toList());
		}

		return outputlist;
	}

}

public class Lab2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 125; i++) {
			list.add("str" + i);
		}
		Predicate<String> pred = (s) -> s.length() > 4;
		MyRecursiveTask task = new MyRecursiveTask(list, pred);
		List<String> sortedlist = task.compute();
		sortedlist.forEach(System.out::println);
	}
}
