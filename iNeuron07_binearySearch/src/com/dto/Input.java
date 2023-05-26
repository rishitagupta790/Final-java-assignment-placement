package com.dto;

import java.util.Scanner;

public class Input {
	// int arr[]= new int[] {1,2,3} ;

	Scanner scan = new Scanner(System.in);
	int key;

	public Integer findNum() {
		int num[] = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100 };
		System.out.println("Enter Number to search :: ");
		key = scan.nextInt();
		int low = 0;
		int high = num.length - 1;
		// System.out.println(low + " " + high); // for checking

		while (low <= high) {
			int mid = (low + high) / 2;
			if (num[mid] == key) {
				return mid;
			} else if (num[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}
		return -1;
	}
}
