package Example;

import java.util.Scanner;

public class PersonInfo extends Person implements Personable{
	String phone;
	String addr;
	
	PersonInfo() {
		//super();
	}
	
	@Override
	public boolean input(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학번 입력 => ");
		this.hakbun = scan.next();
		
		if(hakbun.toLowerCase().equals("exit"))
			return true;
		
		System.out.println("이름 입력 => ");
		this.irum = scan.next();
		System.out.println("전화번호 입력 => ");
		this.phone = scan.next();
		System.out.println("주소 입력 => ");
		this.addr = scan.next();
		
		return false;
	}
	
	@Override
	public void output() {
		System.out.printf("%4s   %3s   %13s   %3s  \n",
				hakbun, irum, phone, addr);
	}
}
