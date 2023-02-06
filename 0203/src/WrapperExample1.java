
public class WrapperExample1 {
	public static void main(String[] args) {
		// 더 이상 이렇게 명시하지 않는다.
//		Integer obj1 = new Integer(12); 
//		Integer obj2 = new Integer(7); 
		
		//String 12를 Integer 형 객체로 생성
		Integer obj1 = Integer.parseInt("12"); 
		Integer obj2 = 7; 
		int sum = obj1.intValue() + obj2.intValue();
		System.out.println(sum);
	}
}
