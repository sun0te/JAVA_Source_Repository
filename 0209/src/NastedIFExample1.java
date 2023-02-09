//[예제 16-19] MP3PlayerFactory 클래스를 사용하는 프로그램

public class NastedIFExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3PlayerFactory factory = new MP3PlayerFactory();
		PlayerFactory.Player player = factory.createPlayer();
		player.play("아리랑");
		player.stop();
	}

}
