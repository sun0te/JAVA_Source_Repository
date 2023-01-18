import java.util.Scanner;
//못풀었
public class TestGugudan3 {

	public static void main(String[] args) {
		int res[];
		
		res = input_num();	
		print_dan(res);
		print_gugudan(res);
		
		
	}

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
	
	static void print_dan(int val[]) {
		
		for(int i = val[0]; i <= val[1]; i++) 
		{
			System.out.print("*** "+ i + "단 ***  ");
		} 
		System.out.println();
		
	}
	
	static void print_gugudan(int val[]) {
		
		for (int i = 1; i <= 9; i++) 
		{
			for (int j = val[0]; j <= val[1]; j++) 
			{
				System.out.printf("%d * %d = %2d   ", j, i, j*i);
			}
			System.out.println();
		}
		
	}
	
	

}
