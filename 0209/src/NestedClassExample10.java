//[예제 16-17] 이름 없는 이너 클래스의 예 (2)
public class NestedClassExample10 {

	public static void main(String[] args) {
		
		//Player 인터페이스를 구현하는 이름 없는 이너 클래스
		Player obj = new Player() {
			public void play(String source) {
				System.out.println("플레이 시작: " + source);
			}
			public void stop() {
				System.out.println("플레이 종료");
			}
		};
		//이름 없는 이너 클래스의 메소드 호출
		obj.play("LetItBe.mp3");
		obj.stop();
	}

}
