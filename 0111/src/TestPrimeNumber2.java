import java.util.Scanner;

public class TestPrimeNumber2 {

	public static void main(String[] args) {
		int res[] = input_num();
		//print_prime(res); //(아래 코드에서 소수가 출력되므로 삭제)
		int res2[] = print_prime(res);
		print_total(res2);
	}

	//메서드 1
	static int[] input_num() {
		Scanner in = new Scanner(System.in);
		int num1, num2;
		int val[] = new int[2];	// 작은 수와 큰 수를 저장할 배열
				
		System.out.println("첫번째 숫자 입력 => ");
		num1 = in.nextInt();
		System.out.println("두번째 숫자 입력 => ");
		num2 = in.nextInt();
		System.out.println();
				
		if(num1 < num2) {
			val[0] = num1;
			val[1] = num2;
		} else {
			val[0] = num2;
			val[1] = num1;
		}
		return val;
	}
	
	static int[] print_prime(int val[]) {
		int val2[] = new int[2];
		int cnt = 0;
		int hap = 0;
		int i, j;
		
		for (i = val[0]; i <= val[1]; i++)	//소수를 계산하는 부분
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
		System.out.println();
		val2[0] = cnt;
		val2[1] = hap;
		return val2;
	}
	
	static void print_total(int val2[]) {
		int cnt = val2[0];
		int hap = val2[1];
		
		if (cnt % 10 != 0)
			System.out.println();
						
		System.out.println("총 소수의 갯수 = "+ cnt);
		System.out.println("총 소수 합 = "+ hap);		
		
	}
	

}
