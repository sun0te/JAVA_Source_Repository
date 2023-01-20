import java.util.Scanner;
import java.util.StringTokenizer;

public class ExampleCalculator {

	public static void main(String[] args) {
		String str = null;	//입력
		int result = 0;	//계산 결과
		String func;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("수식 입력 => ");
			str = sc.next();
			
			if (!input_check(str)) {
			System.out.println("수식 입력 오류!!");
			continue;
			} else
				break;
		}//while (수식입력)
		
		StringTokenizer stok = new StringTokenizer(str, "+=*/", true);
		
		while(stok.hasMoreTokens()) {
			func = stok.nextToken();
			if(func.equals("+")) {
				func = stok.nextToken();
				result += Integer.parseInt(func);
			} else if(func.equals("-")) {
				func = stok.nextToken();
				result -= Integer.parseInt(func);
			} else if(func.equals("*")) {
				func = stok.nextToken();
				result *= Integer.parseInt(func);
			} else if(func.equals("/")) {
				func = stok.nextToken();
				result /= Integer.parseInt(func);
			} else
				result = Integer.parseInt(func);
		}//while (사칙연산 기호)
		
		System.out.println("수식 결과값 : "+result);
		
	} 

	static boolean input_check(String str) {
		char ch;

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (i == 0) { //'-'인지 검사
				if (ch < '0' || ch > '9') //ch가 숫자인지 검사(유니코드로 비교)
					return false;	
			} else if (i == str.length()-1) {
				if (ch < '0' || ch > '9') //ch가 숫자인지 검사(유니코드로 비교)
					return false;
			}
		}// for 앞 뒤 부호
		
		for(int i = 1; i< str.length()-1; i++) {
			if (str.charAt(i)<'0'| str.charAt(i) >'9') { 
				if (str.charAt(i)!='+'& str.charAt(i)!='-'&str.charAt(i)!='*'&str.charAt(i)!='/')
					return false;
				}
		}//for 문자 감지
	return true;
	}
}
