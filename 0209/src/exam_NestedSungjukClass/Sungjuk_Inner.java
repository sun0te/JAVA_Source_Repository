package exam_NestedSungjukClass;

import java.util.ArrayList;
import java.util.Scanner;


public class Sungjuk_Inner {
	ArrayList<Sungjuk> list = new ArrayList<Sungjuk>();	//Item 클래스 포함
	
	void addSungjuk() {
		Sungjuk obj = new Sungjuk();
		obj.input();
		obj.process();
		list.add(obj);
	}
	
	/*
	void removeItem(Sungjuk obj) {
		list.remove(obj);
	}
	*/
	
	int getSungjukNum() {
		return list.size();
	}
	
	Sungjuk getSungjuk(int index) {
		return list.get(index);
	}
	
	double getTotalAvg() {
		double tot_avg = 0;
		for(Sungjuk obj : list)
			tot_avg += obj.avg;
		return tot_avg;
	}
	
	
	
	class Sungjuk { // 상품 항목 클래스, 이너 클래스
		String hakbun, irum;
		int kor, eng, math, tot;
		double avg;
		String grade;
		
		static int cnt = 0;
		static double tot_avg = 0.0;
		
		Sungjuk() {
			
		}
		
		Sungjuk(String hakbun, String irum, int kor, int eng, int math){
			this.hakbun = hakbun;
			this.irum = irum;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		void input()
		{
			Scanner scan = new Scanner(System.in);
			
			System.out.print("학번 입력 => ");
			hakbun = scan.next();
			System.out.print("이름 입력 => ");
			irum = scan.next();
			System.out.print("국어 입력 => ");
			kor = scan.nextInt();
			System.out.print("영어 입력 => ");
			eng = scan.nextInt();
			System.out.print("수학 입력 => ");
			math = scan.nextInt();
		}
		
		void process()
		{
			tot = kor + eng + math;
			avg = tot / 3;
			
			switch ((int)avg / 10) {
				case 10:
				case 9:
					grade = "수";
					break;
				case 8:
					grade = "우";
					break;
				case 7:
					grade = "미";
					break;
				case 6:
					grade = "양";
					break;
				default:
					grade = "가";
					break;
			}
		}
		
		void output()
		{
			System.out.printf("%4s  %3s  %3d   %3d   %3d   %3d  %5.2f  %2s\n",
					hakbun, irum, kor, eng, math, tot, avg, grade);
		}
	}

}
