package com.dao.abs;

import java.util.Scanner;

public class Faculty extends FacultyAbstract {

	@SuppressWarnings("resource")
	@Override
	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name :: ");
		String name = scan.nextLine();
		System.out.println("Welcom " + name);

	}

	@Override
	public int calculateSalary() {
		System.out.println("Manager post ");
		return 50000;
	}

}
