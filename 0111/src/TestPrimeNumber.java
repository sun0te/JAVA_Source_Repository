import java.util.Scanner;

public class TestPrimeNumber {

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int num1, num2, num;
		int allcount = 0, sum = 0;
		
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
			int count = 0;
			for(int j = 2; j <= i; j++)
			{
				if(i % j == 0)
				{
					count++;
				}
			}
			
			if(count == 1)	//1과 자기 자신만 나누어 떨어진 횟수 1회
			{
				allcount++;
				sum += i;
				System.out.printf("%3d  ", i);
				if (allcount % 10 == 0) {
					System.out.println();
				}
			}

		}
		
		System.out.println();
		System.out.println();
		System.out.printf("총소수의 갯수 = %d", allcount);
		System.out.println();
		System.out.printf("총 소수의 합 = %d", sum);
		
		
	}

}
