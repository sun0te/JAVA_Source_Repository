package solution_SawonTable;

import java.util.Scanner;

public class Sawon {
	
	
	String sabun; 
	String deptname;
	String irum;
	String gender;
	String email;

	Sawon() {
		
	}
	
	void inputData() {
		Scanner scan = new Scanner(System.in);
		System.out.println("사원번호 입력 => ");
		sabun = scan.next();
		System.out.println("부서 입력 => ");
		deptname = scan.next();
		System.out.println("이름 입력 => ");
		irum = scan.next();
		System.out.println("성별 입력 => ");
		gender = scan.next();
		System.out.println("이메일 입력 => ");
		email= scan.next();
	}
	
	void outputData() {
		System.out.printf("%5s %6s %9s %9s %20s \n", 
				sabun,deptname,irum,gender,email);
	}

}

