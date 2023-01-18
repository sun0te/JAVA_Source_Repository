
public class ExampleSangpum {

	public static void main(String[] args) {
		
		Sangpum obj = new Sangpum(); 
		obj.inputGoods();
		obj.pricess_sangpum();
		
		System.out.println("\n\t\t *** 상품 정보 ***");
		System.out.println("===============================================================");
		System.out.println("상품코드  상품명 수량   단가   금액");
		System.out.println("===============================================================");
		obj.outputGoods();
		System.out.println("===============================================================");
		
	}

}
