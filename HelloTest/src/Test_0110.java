
public class Test_0110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1; 
		int even = 0, odd = 0;

		/*
		while (num <= 100)
		{
			if (num % 2 == 0) {
				even += num;
			}
			 else
				 odd += num;
			
			num++; 
		}
		*/
		
		for(int i = 0; i <= 100; i++) {
			if (i %2 == 0) {
				even += i;
			} else 
				odd += i;
		}
		
		
		System.out.println("홀수의 합 : " + odd);
		System.out.println("짝수의 합 : " + even);
		
	}
}