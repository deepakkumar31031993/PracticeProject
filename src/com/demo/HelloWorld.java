package com.demo;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*while(true) {
			System.out.println("Haan Bhai Jhaabhoo ke haal h..!!");
			Thread.sleep(1000);
		}*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number 1 ");
		int a = sc.nextInt();
		System.out.println("Enter number 2");
		int b = sc.nextInt();
				System.out.println("diff is " + diff(a,b));
		sc.close();
	}
	
	
	public static int sum(int a , int b) {
		return a+b;
	}
	
	public static int diff(int a , int b) {
		if(a>b)
			return a-b;
		
		return b-a;
	}

}
