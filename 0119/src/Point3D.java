
public class Point3D extends Point {

	int z;
	
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	int getX() { // 잘못된 메소드
		return x;
	}
	
	int getY() { // 잘못된 메소드
		return y;
	}
	
	int getZ() {
		return y;
	}
	 
}
