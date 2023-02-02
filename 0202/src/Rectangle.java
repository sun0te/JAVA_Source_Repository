
public class Rectangle implements Cloneable {

	int width, height;
	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Object clone() { //clon() 오버라이드
		try { 
			return super.clone(); 
		} 
		catch (CloneNotSupportedException e) { 
			return null; 
		} 
	} 
	
	//getClass 메소드 사용을 위한 추가
	int getArea() { 
		 return width * height;
	}
}
