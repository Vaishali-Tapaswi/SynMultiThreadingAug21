package fk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to continue");
		scanner.nextInt();
		List<String> list = new ArrayList<String>();
		for(int i =0;i<50000;i++)
		{
				list.add("str"+i);
		}
//		list.stream().filter((s)->s.length()>6).forEach(e->System.out.print(e + " "));
		list.parallelStream().filter((s)->s.length()>6).forEach(e->System.out.print(e + " "));
	}

}
