
public class inheritanceExample1 {

	public static void main(String[] args) {
		
		//객체를 초기화 -> 파라미터 4개 Account의 생성자가 호출될 수 있도록 
		//CheckingAccount에 super(accountNo, ownerName, balance); 추가
		CheckingAccount obj = new CheckingAccount("111-22-33333333",
				 "홍길동", 0, "5555-6666-7777-8888");
		
		
		//CheckingAccount obj = new CheckingAccount();
		 //obj.accountNo = "111-22-33333333"; //Account 클래스에 상속받은 필드
		 //obj.ownerName = "홍길동"; 			//Account 클래스에 상속받은 필드
		 //obj.cardNo = "5555-6666-7777-8888"; 
		 
		obj.deposit(100000); 
		 
		 try 
		 {
			int paidAmount = obj.pay("5555-6666-7777-8888", 47000); //Account 클래스에 상속받은 메소드
		 	System.out.println("지불액:" + paidAmount);
		 	System.out.println("잔액:" + obj.balance);
		 }
		 
		 catch (Exception e) { 
			 String msg = e.getMessage();
			 System.out.println(msg);
		 }

	}

}
