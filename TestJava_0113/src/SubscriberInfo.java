
public class SubscriberInfo {
	String name, id, password;
	String phoneNo, address;
	
	SubscriberInfo(){}	//디폴트생성자 생성 -> 메인에서 SubscriberInfo obj3 = new SubscriberInfo(); 객체 생성 가능
	SubscriberInfo(String name, String id, String password) {
		this.name = name; 
		this.id = id; 
		this.password = password; 
	}
	
	SubscriberInfo(String name, String id, String password, String phoneNo, String address) {
		this(name, id, password); //맨 앞에 배치할 것
		this.phoneNo = phoneNo;
		this.address = address;
	}
	 
	void changePassword(String password) {
		this.password = password; 
	}
	
	void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	void setAddress(String address) {
		this.address = address;
	}
}
