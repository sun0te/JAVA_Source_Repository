
public class Rectangle implements PlaneObject {

	Location location;
	int width, height;
	
	//PlaneObject 인터페이스로부터 상속받은 정적 네스티드 클래스의 생성자 호출
	Rectangle(int x, int y, int width, int height) {
		this.location = new Location(x, y);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(int x, int y) {
		//정적 네스티드 클래스의 필드 사용

		location.x = x;
		location.y = y;

	}

}
