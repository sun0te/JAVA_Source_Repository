
public class RefTypeExample2 {
	
	public static void main(String args[]) {
		Point obj = new Point(10, 20);
		System.out.printf("(%d, %d) %n", obj.x, obj.y);
		rearrange(obj); // 레퍼런스 타입의 파라이커를 메소드에 넘겨줌
		System.out.printf("(%d, %d) %n", obj.x, obj.y);
		}
	
	static void rearrange(Point point) { //호출
		//파라미터 변수의 필드에 다른 값을 대입
		point.x = 30; 
		point.y = 40; 
	}

}
