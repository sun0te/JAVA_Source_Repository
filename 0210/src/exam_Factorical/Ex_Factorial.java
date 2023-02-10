package exam_Factorical;
//실습 문제 양의정수 팩토리얼
import java.util.Scanner;

public class Ex_Factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("양의 정수를 입력하세요 >> ");
		int num = scan.nextInt();
		
		long result = 1;
		for(int i = 1; i <= num; i++) {
			result *= i;
		}
		System.out.printf("%d factorial은 %d입니다", num,result);
	}

}
