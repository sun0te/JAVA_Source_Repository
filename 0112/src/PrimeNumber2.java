import java.util.Scanner;

public class PrimeNumber2 {

	public static void main(String[] args) {
		
		//int res[]  : 배열 객체의 주소를 보관할 수 있는 레퍼런스를 생성한다 
		//함수호출 : input_num();
		//print_prime(res); //(아래 코드에서 소수가 출력되므로 삭제)
		//메인 메소드로 복귀하면 메서드1에있는 변수값은 사라진다.
		//res[] 에 전달된 주소값만 남게 된다.		
		
		//int res[];  res = input_num();
		int res[] = input_num();
		int cnt_hap[] = process_primenumber(res);
		print_cnt(cnt_hap);
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
		return val;	//입력한 값의 "주소"를 반환
	}
	
	
	// 정수형 반환값이 있다(총 횟수, 총 합)
	static int[] process_primenumber(int val[]) {
		//누적하는 값은 초기값이 필요하다.
		//cnt 는 이 메서드 내에서만 사용하는 지역 변수이다.
		int i, j;	
		int cnt_hap[] = new int[2];
		
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
				cnt_hap[0]++;
				if(cnt_hap[0] % 10 == 0)	// 한 줄에 10개씩
					System.out.println();
				cnt_hap[1] += i;
			}
			
		}	
		return cnt_hap;
	}
	
	static void print_cnt(int cnt_hap[]) {
		if (cnt_hap[0] % 10 != 0)
			System.out.println();
		
		System.out.println();
		System.out.println("총 소수의 갯수 = "+ cnt_hap[0]);
		System.out.println("총 소수 합 = "+ cnt_hap[1]);
	}

	
}
