
public class Circle {
	int radius; // 반지름
	
	Circle(int radius) {
		this.radius = radius;
	}
	public boolean equals(Object obj) { //레퍼런스타입이 어떤 것이든 받을 수 있게 object obj 로 설정
		 if (!(obj instanceof Circle))  //객체 instanceof 클래스 : 파라미터 객체가 Circle 타입인지 검사
			 
			 return false; 
		 
		 Circle circle = (Circle) obj; 
		 // 파라미터 객체를 Circle 타입으로 캐스트
		 // obj 객체를 Circle 캐스트타입 연산이 가능한지 true, false
		 
		 if (radius == circle.radius) // 파라미터 객체와 객체 자신의 radius 필드 값을 비교
			 return true; 
		 else 
			 return false; 
	}
}
