package exam_Factorical;

import java.util.Scanner;

public class Recursive_Factorial {

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, result;
		System.out.printf("정수를 입력하세요 -> ");
		n = in.nextInt();
		result = fact(n);
		System.out.printf("\n\n%d의 factorial 값은 %d입니다. \n", n, result);
	}
	
	static int fact(int n)
	{
		int value;
		if (n <= 1) {
			System.out.println("\nfact(1)함수 호출!");
			System.out.printf("\nfact(1)값 1 반환!");
			return 1;
		}
		else {
			System.out.printf("\nfact(%d)함수 호출!", n);
			value = (n *fact(n-1));
			System.out.printf("\nfact(%d)값 %d 반환!", n, value);
			return value;
		}
	}

}
