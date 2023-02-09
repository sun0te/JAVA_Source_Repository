//[예제 16-16] 이름 없는 이너 클래스의 예 (1)
public class NestedClassExample9 {

	public static void main(String[] args) {
		//이름 없는 이너 클래스의 선언 및 객체 생성
		MessageSender obj = new MessageSender() {
			void send(String message) {
				System.out.println("발신: 마이다스");
				System.out.println("수신: 빌 게이츠");
				System.out.println("메시지: " + message);
				System.out.println();
			}
		};
		obj.send("굿 모닝"); //이름 없는 이너 클래스의 메소드 호출
	}

}
