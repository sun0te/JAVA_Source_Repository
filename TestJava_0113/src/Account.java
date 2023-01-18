
public class Account {
	String accountNo; // 계좌번호
	String ownerName; // 예금주 이름
	int balance; // 잔액
	
	//디폴트 메서드 추가
	Account() {}
	
	
	Account(String accountNo, String ownerName, int balance) { // 생성자
		this.accountNo = accountNo;
		this.ownerName = ownerName; 
		this.balance = balance; 
	}
	 
	void deposit(int amount) { 
		balance += amount;
	}
	
	int withdraw(int amount) {
		if (balance < amount)
			return 0;
		balance -= amount;
		return amount;
	}

}
