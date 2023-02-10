package exam_Factorical;

import java.util.Scanner;

public class Recursive_fibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("임의의 수를 입력하세요 : ");
		int n = scan.nextInt();
		
		System.out.print("Fibonacci >> ");
		for(int i = 0; i < n; i++) {
			System.out.print(fib(i) + " ");
		}

	}
	
	static int fib(int n) {
	    if (n <= 1)
	      return 1;
	    else
	      return fib(n-1) + fib(n-2);
	  }
}
