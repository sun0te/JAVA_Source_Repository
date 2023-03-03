package chap01;

import java.util.Scanner;

public class PrintSquare {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		
		System.out.println("정사각형을 출력합니다.");
		
		do {
			System.out.print("정사각형 길이 : ");
			n = stdIn.nextInt();
		} while (n <= 0);
		
		for(int i = 0; i < n; i++) {
			System.out.println("*".repeat(n));
		}

	}

}
