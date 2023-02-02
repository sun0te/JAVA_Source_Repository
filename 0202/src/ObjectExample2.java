
public class ObjectExample2 {

	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("57293", 100);
//		String str = obj.toString(); // Object 가 지원하는 toString() 사용
		System.out.println(obj + " => 테스트");	//(obj.toString()) 도 가능
	}

}

