import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner n = new Scanner(System.in);
		int num1, num2, min, max, cnt = 0;
		int i, j;
		int hap = 0;
		
		System.out.println("첫번째 숫자 입력 => ");
		num1 = n.nextInt();
		System.out.println("두번째 숫자 입력 => ");
		num2 = n.nextInt();
		System.out.println();
		
		if(num1 < num2) {
			min = num1;
			max = num2;
		} else {
			min = num2;
			max = num1;
		}
		
		
		for (i = min; i <= max; i++)	//소수를 계산하는 부분
		{
			for(j = 2; j < i; j++)
			{
				if(i%j == 0)
					break;	//i 변수의  값은 더 이상 소수가 아님
			}
			
			if(i == j)	//i 변수의 값이 소수인 경우
			{
				System.out.printf("%5d", i);	// 소수 출력
				cnt++;
				if(cnt % 10 == 0)	// 한 줄에 10개씩
					System.out.println();
				hap += i;	// 소수의 합
			}
		}	//소수 계산 끝
		
		if(cnt % 10 != 0)
			System.out.println();
		
		System.out.println("총 소수의 갯수 = "+ cnt);
		System.out.println("총 소수 합 = "+ hap);
		
		
	}

}
