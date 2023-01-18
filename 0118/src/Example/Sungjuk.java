package Example;
import java.util.Scanner;

public class Sungjuk extends Person implements Personable {
	
	int kor;
	int eng;
	int math;
	int tot = 0;
	double avg = 0;
	String grade;
	
	Sungjuk() {
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
		System.out.println("국어 입력 => ");
		this.kor = scan.nextInt();
		System.out.println("영어 입력 => ");
		this.eng = scan.nextInt();
		System.out.println("수학 입력 => ");
		this.math = scan.nextInt();
		
		return false;
	}

	@Override
	public void output() {
		System.out.printf("%4s   %3s   %3d   %3d   %3d   %3d   %5.2f   %2s\n",
				hakbun, irum, kor, eng, math, tot, avg, grade);
	}
	
	void process() {
		tot += kor + eng + math;
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

}
