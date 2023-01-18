
public class GoodsStock {
	String goodsCode;
	 int stockNum; 
	 
	 GoodsStock() {
		 
	 }
	 
	//우리가 명시적으로 만든 생성자 -> 디폴트 생성자는 자동으로 생성이 안된다. 그래서 에러발생 
	 GoodsStock(String goodsCode, int stockNum) { 
		 this.goodsCode = goodsCode; 
		 this.stockNum = stockNum; 
	 } 
	 
	 void addStock(int amount) {
		 this.stockNum += amount; 
	 }

	 int subtractStock(int amount) {
		 if (this.stockNum < amount)
			 //throw new Exception("잔액이 부족합니다.");   //에러
				throw new ArithmeticException("잔액이 부족합니다.");   //에러 안 남
		 this.stockNum -= amount; 
		 return amount;
	 }
		 
}