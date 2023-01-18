import java.util.Scanner;

public class Sangpum {
		String goodsCode;
		String goodsName;
		int stockNum;
		int price;
		int allprice;
		
		public Sangpum() {
			
		}
	
	boolean inputGoods() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("상품코드 입력 => ");
		this.goodsCode = scan.next();
		
		if(goodsCode.equals("exit"))
			return true;
		
		System.out.println("상품명 입력 => ");
		this.goodsName = scan.next();
		System.out.println("수량 입력 => ");
		this.stockNum = scan.nextInt();
		System.out.println("단가 입력 => ");
		this.price = scan.nextInt();
		
		return false;
	}
	
	void pricess_sangpum() {
		this.allprice = this.stockNum * this.price;
	}
	
	void outputGoods() {
		System.out.printf("%4s	%6s	%4d	%7d	%8d \n", goodsCode, goodsName, stockNum, price, allprice);
	}
	
	
	
	
}
