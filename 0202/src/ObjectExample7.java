import java.util.GregorianCalendar;

public class ObjectExample7 {

	public static void main(String[] args) {
		//객체를 생성
		GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1);
		//clone 메소드로 객체를 복제
		GregorianCalendar obj2 = (GregorianCalendar) obj1.clone(); 
		
		//원본 객체와 복제 객체의 값을 출력
		System.out.printf("%tF %n", obj1);
		System.out.printf("%tF %n", obj2);
		
		//추가
		if(obj1.equals(obj2))
			System.out.println("같음");
		else
			System.out.println("다름");
	}

}
