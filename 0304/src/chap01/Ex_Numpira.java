package chap01;

import java.util.Scanner;

public class Ex_Numpira {

	//--- 특수문자 * 을 나열하여 피라미드를 출력 ---//
			static void spira(int n) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n - i; j++)  //공백 직각 이등변(왼쪽 위)방향
						System.out.print(' ');
					for (int j = 1; j <= (i-1)*2+1; j++) //(i - 1) * 2 + 1개 (0번째 1, 1번째 3, 2번재 5, 3번째 7...)
						System.out.print(i % 10);
					System.out.println();
				}
			}

			public static void main(String[] args) {
				Scanner stdIn = new Scanner(System.in);
				int n;

				System.out.println("피라미드를 출력합니다.");

				do {
					System.out.print("길이는  : ");
					n = stdIn.nextInt();
				} while (n <= 0);

				spira(n);
	}

}
