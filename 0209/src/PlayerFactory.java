//[예제 16-18] 네스티드 인터페이스를 포함하는 클래스와 서브클래스

//네스티드 인터페이스
abstract class PlayerFactory {
	abstract Player createPlayer();
	interface Player {
		void play(String source);
		void stop();
	}
}