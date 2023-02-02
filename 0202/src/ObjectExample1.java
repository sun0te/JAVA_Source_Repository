import java.io.File;

public class ObjectExample1 {

	public static void main(String[] args) {
		File file = new File("C:\\뻐꾸기"); // 백슬래시 두 개있어야 하나 출력
//		String str = file.toString(); 
		System.out.println(file);	//레퍼런스 변수 file( 객체 출력)
	}

}
