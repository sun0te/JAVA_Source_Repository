
public class AccessControlExample1 {

	public static void main(String[] args) {
		Fraction obj = new Fraction(100, 3);
		System.out.println("100/3 = " + obj.getDouble());	//private 접근제한자면 에러발생
	}

}
