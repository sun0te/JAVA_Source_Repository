import java.util.Scanner;

public class Sungjuk {
	String hakbun, irum;
	int kor, eng, math;
	
	int tot = 0;
	double avg = 0;
	String grade;
	
	static int cnt = 0;
	static double tot_avg = 0;
	
	Sungjuk() {
		
	}
	
	boolean input_Score() {	//true or false
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학번 입력 => ");
		this.hakbun = scan.next();
		
		if(hakbun.equals("exit"))
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
	
	void process_Score() {
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
	
	void output_Score() {
		System.out.printf("%4s   %3s   %3d   %3d   %3d   %3d   %5.2f   %2s\n",
				hakbun, irum, kor, eng, math, tot, avg, grade);
		}
	
	static double getTotalAvg() {
		return tot_avg / cnt;
	}
	
}
