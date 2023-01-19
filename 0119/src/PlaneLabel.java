
public class PlaneLabel implements Movable {
	
	int x, y;
	String str;
	
	PlaneLabel(int x, int y, String str) {
		this.x = x;
		this.y = y;
		this.str = str;
	}

	@Override
	void moveTo(int x, int y) {	// 잘못된 메소드, public 을 붙여야 한다 
		this.x = x;
		this.y = y;
	}

}
