import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemExample2 {

	public static void main(String[] args) {
		//가급적이면 해당 예제의 Buffer 객체 예제를 사용
		BufferedReader reader = new BufferedReader( 
				new InputStreamReader(System.in)); 
		try {
			String str = reader.readLine(); 
			System.out.println("입력된 문자열: " + str);
		}
		catch (IOException e) {
			System.out.println("키보드 입력 에러");
		}

	}

}
