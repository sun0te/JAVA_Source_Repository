
public class CheckingAccount extends Account {
	String cardNo; 	//직불카드 번호 필드
	
	//CheckingAccount() {	//super() : 부모 클래스 디폴트 생성자 자동 호출
	//	super();	//this();
	//}
	
	CheckingAccount(String accountNo, String ownerName,
		int balance, String cardNo) { // 생성자
		//super();
		super(accountNo, ownerName, balance);	//명시적으로 부모 클래스 생성자 호출
		
		//this.accountNo = accountNo;
		//this.ownerName = ownerName;
		//this.balance = balance;
		this.cardNo = cardNo;
	}
	

	int pay(String cardNo, int amount) throws Exception 
	{ 
	if (!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("지불이 불가능합니다.");
		return withdraw(amount);
	}

}
