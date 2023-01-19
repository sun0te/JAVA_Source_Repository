
public class Point {
	
	int x, y; // 필드
	
	Point(int x, int y) { // 생성자, 디폴트 생성자는 자동으로 만들어지지 않는다
		this.x = x;
		this.y = y;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}

}
