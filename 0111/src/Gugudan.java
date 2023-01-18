import java.util.Scanner;
//강사님 코드
public class Gugudan {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1, num2, min, max;
		
		System.out.println("첫번째 숫자 입력 => ");
		num1 = in.nextInt();
		System.out.println("두번째 숫자 입력 => ");
		num2 = in.nextInt();
		System.out.println();
		
		if(num1 < num2) {
			min = num1;
			max = num2;
		} else {
			min = num2;
			max = num1;
		}
		
		for(int i = min; i <= max; i++) 
		{
			System.out.print("*** "+ i + "단 *** ");
		} 
		System.out.println();
		
		for (int i = 1; i <= 9; i++) 
		{
			for (int j = min; j <= max; j++) 
			{
				System.out.printf("%d * %d = %2d   ", j, i, j*i);
			}
			System.out.println();
		}
		
		
		
	}

}
