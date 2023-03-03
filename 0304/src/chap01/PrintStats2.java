package chap01;

import java.util.Scanner;

public class PrintStats2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n, w;
		
		System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");
		
		do {
			System.out.print("n값 : ");
			n = stdIn.nextInt();
		} while (n <= 0);
		
		do {
			System.out.print("w값 : ");
			w = stdIn.nextInt();
		} while(w <= 0 || w > n);
		
		//*를 w개 출력하면서 n/w번 실행한다.
		//ex) n=15, w=5 이면 *****를(5개) 3번(15/5) 출력
		for(int i = 0; i < n / w; i++)
			System.out.println("*".repeat(w));
		
		//n이 w의 배수가 아니면 남아있는 마지막 줄 줄바꿈
		//ex) n=14, w=5 이면 rest는 4가 저장[0, 1, 2, 3], 출바꿈 후 출력
		int rest = n % w;
		if(rest != 0)
			System.out.println("*".repeat(rest));
		
	}

}
