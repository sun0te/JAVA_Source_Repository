package exam_Factorical;
import java.util.Scanner;

//[실습] 문제 피보나치 수열을 구해서 출력하는 프로그램을 작성하시오.
//처리조건 : 임의의 수를 입력하면 입력한 수만큼의 피보나치 수열을 구해서 출력한다.
//f(n) = f(n-2)+f(n-1)

public class Ex_fibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("임의의 수를 입력하세요 : ");
		int n = scan.nextInt();
		
		int num1 = 0, num2 = 1, result = 1;
        
        for(int i = 0; i < n; i++)
        {
            System.out.print(result + " ");
            result = num1 + num2; 
            num1 = num2;
            num2 = result; 
        }
		
	}
}
