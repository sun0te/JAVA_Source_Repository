
public class ClassExample1 {

	public static void main(String[] args) {
		//변수 선언
		GoodsStock obj;
		//객체 생성
		obj = new GoodsStock("52135", 200);	
		
		//obj.goodsCode = "52135";
		//obj.stockNum = 200;
		
		System.out.println("상품코드:" + obj.goodsCode);
		System.out.println("재고수량:" + obj.stockNum);
		obj.addStock(1000);	//메소드 호출
		System.out.println("상품코드:" + obj.goodsCode);
		System.out.println("재고수량:" + obj.stockNum);
		

	}

}
