
public class RefTypeExample1 {

	public static void main(String[] args) {
		//하나의 객체를 생성해서 두 개의 변수에 대입
		Point obj1 = new Point(10, 20);
		Point obj2 = obj1;
		System.out.printf("obj1 = (%d, %d) %n", obj1.x, obj1.y);
		System.out.printf("obj2 = (%d, %d) %n", obj2.x, obj2.y);
		
		//obj2의 x 필드에 다른 값 대입 
		obj2.x = 30;
		System.out.printf("obj1 = (%d, %d) %n", obj1.x, obj1.y);
		System.out.printf("obj2 = (%d, %d) %n", obj2.x, obj2.y);
	}

}
