
public class RefTypeExample6 {
	public static void main(String args[]) {
		
		Account obj1 = new Account("AAA", "AA", 10);
//		CheckingAccount obj2 = (CheckingAccount)obj1;
		Account obj = new CheckingAccount("111-22-33333333", "홍길동", 10, "4444-5555-6666-7777");
		CheckingAccount obj2 = (CheckingAccount)obj; //강제 형변환, 대입이 가능해진다.
		
		 
		 try {
			 int amount = obj2.pay("4444-5555-6666-7777", 47000); 
			 System.out.println("인출액: " + amount);
			 System.out.println("카드번호: " + obj2.cardNo);
		 }
		 catch (Exception e) { 
			 System.out.println(e.getMessage());
		 }
	}
}
