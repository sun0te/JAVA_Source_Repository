import java.util.Scanner;
//내가 짠 코드
public class Testgugudan {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int num1, num2, num;
		
		System.out.println("첫번째 숫자 입력 => ");
		num1 = n.nextInt();
		System.out.println("두번째 숫자 입력 => ");
		num2 = n.nextInt();
		System.out.println();
		
		if(num1 > num2) 
		{
			num = num1;
			num1 = num2;
			num2 = num;
			
		}
		
		for(int i = num1; i <= num2; i++) 
		{
			System.out.print("*** " + i + "단 ***   ");
		} System.out.println();
		
		
		for(int i = 1; i < 10; i++) 
		{
			for(int j = num1; j <= num2; j ++)
			{
				System.out.printf("%d * %d =  %2d   ", j, i, i*j);
			} System.out.println();
		}
		

	}

}
