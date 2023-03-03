package chap01;

import java.util.Scanner;

// *를 n개 출력하되 w개마다 줄바꿈
public class PrintStarts1 {

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
		
		//변수 i 갑을 w값으로 나눈 나머지가 w-1일 때 줄바꿈
		//ex) w = 5일 때 i 값이 4, 9, 14일 때 줄바꿈
		for(int i = 0; i < n; i++) {
			System.out.print("*");
			if(i % w == w - 1)
				System.out.println();
		}
		//n값이 w의 배수가 아니면 마지막 줄바꿈은 여기서 한다. (n이 w의 배수가 아닐 때만 실행)
		if(n % w != 0)
			System.out.println();
		
	}

}
