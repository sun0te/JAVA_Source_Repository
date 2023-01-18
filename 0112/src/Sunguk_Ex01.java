import java.util.Scanner;
//내가 쓴 코드
public class Sunguk_Ex01 {

	public static void main(String[] args) {
		String[] hakbun = new String[3];
		String[] irum = new String[3];
		int[] kor = new int [3]; 
		int[] eng = new int[3];
		int[] math = new int [3];
		int tot[]= new int [3];
		double avg[] = new double [3];
		String grade[] = new String[3];
		
		Scanner scan = new Scanner(System.in);
		
		
		
		for(int i = 0; i < 3; i++) {
			System.out.print("학번 입력 => ");
			hakbun[i] = scan.next();
			System.out.print("이름 입력 => ");
			irum[i] = scan.next();
			System.out.print("국어점수 입력 => ");
			kor[i] = scan.nextInt();
			System.out.print("영어점수 입력 => ");
			eng[i] = scan.nextInt();
			System.out.print("수학점수 입력 => ");
			math[i] = scan.nextInt();
			
			tot[i] += kor[i] + eng[i] + math[i];
			avg[i] = tot[i] / 3;
			
			if(avg[i] >= 90)
				grade[i] = "수";
			else if (avg[i] >= 80)
				grade[i] = "우";
			else if (avg[i] >= 70)
				grade[i] = "미";
			else if (avg[i] >= 60)
				grade[i] = "양";
			else 
				grade[i] = "가";
		}
		
		for(int j = 0; j < 3; j ++) {
			System.out.println("\n\t\t *** 성적표 ***");
			System.out.println("===============================================================");
			System.out.println("학번   이름  국어  영어  수학  총점   평균   등급");
			System.out.println("===============================================================");
			System.out.printf("%4s   %3s   %3d   %3d   %3d   %3d   %5.2f   %2s\n",
						hakbun[j], irum[j], kor[j], eng[j], math[j], tot[j], avg[j], grade[j]);
			System.out.println("===============================================================");
		}
		
	}

}
