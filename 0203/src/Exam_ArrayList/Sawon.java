package Exam_ArrayList;

import java.util.Scanner;

public class Sawon {
	static Scanner n = new Scanner(System.in);
	
	private int sabun; 
	private String deptname;
	private String irum;
	private String gender;
	private String email;

	Sawon() {
		
	}
	
	//아래의 메소드를 통해 접근 가능 -> 접근자
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
