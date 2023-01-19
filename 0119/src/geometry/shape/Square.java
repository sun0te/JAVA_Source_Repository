package geometry.shape;

public class Square extends geometry.common.Polygon {
	
	public Square(int x, int y, int sideLength) { 
		super(4);	//슈퍼클래스의 protected 생성자 호출
		
		//슈퍼클래스의 protected 메소드 호출
		setPoint(0, x, y);
		setPoint(1, x + sideLength, y);
		setPoint(2, x + sideLength, y + sideLength);
		setPoint(3, x, y + sideLength);
	}
	
	public int getX(int index) { 
		return x[index];	//슈퍼클래스의 protected 필드 사용
		
	}
		
	public int getY(int index) { 
		return y[index];	//슈퍼클래스의 protected 필드 사용
	}
	
}
