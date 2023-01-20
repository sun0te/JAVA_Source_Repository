import java.util.Scanner;

public class Example_PersonNumber {

	public static void main(String[] args) {
		int i, w=2, chk, hap=0;
		String ju;
		Scanner sc = new Scanner(System.in);
		
		while(true) { //주민번호 입력 검사 시작
			System.out.print("주민번호 입력 => ");
			ju = sc.next();
			
			if (!input_check(ju)){
			System.out.println("주민번호 입력 오류!!");
			continue;
			}
			else
				break;
		} //주민번호 입력 검사 끝
		for(i=0; i<ju.length()-1; i++) {
			if (i==6) //'-'d은 합계 계산에서 스킵
				continue;
			hap += Integer.parseInt(ju.substring(i,i+1)) * w; //w : 가중치
			w++;
			if(w==10)
				w=2; //w가 9 다음은 2
		}
		
		chk = 11 - hap % 11; //11로 나누면 0이나 1이기 때문
		
		if (chk ==10)
			chk = 0;
		else if (chk == 11)
			chk = 1;
		if (chk == Integer.parseInt(ju.substring(13,14)))
			System.out.println("주민번호 : " + ju + "(O)");
		else
			System.out.println("주민번호 : " + ju + "(X)");
	}
	
	static boolean input_check(String str) {
		char ch;
		if (str.length() != 14) //입력받은 문자열이 14자리인지 검사
			return false;
		//문자열을 전달 받아 문자열 길이만큼 한 문자씩 검사
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (i == 6) { //'-'인지 검사
				if (ch != '-')
					return false;
			} else if (i == 7) { //성별 값 검사
				if (!(ch == '1' || ch == '2' || ch == '3' || ch == '4'))
					return false;
			} else if (ch < '0' || ch > '9') //ch가 숫자인지 검사(유니코드로 비교)
				return false;
			
		}
		return true; //메서드 호출 시 false가 되야만 오류 실행문 break
	}
}
