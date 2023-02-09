//[예제 16-18] 네스티드 인터페이스를 포함하는 클래스와 서브클래스

class MP3PlayerFactory extends PlayerFactory {
	public Player createPlayer() {
		return new MP3Player();
	}
	
	//상속받은 네스티드 인터페이스를 구현하는 네스티드 클래스
	class MP3Player implements Player {
		public void play(String source) {
			System.out.println("플레이 시작: " + source);
		}
		public void stop() {
			System.out.println("플레이 종료");
		}
	}
}
