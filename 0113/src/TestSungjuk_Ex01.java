import java.util.Scanner;

//예외처리
public class TestSungjuk_Ex01 {
	
	static int MAX = 3;
	
	public static void main(String[] args) {
		String[] hakbun = new String[MAX];
		String[] irum = new String[MAX];
		int[] kor = new int [MAX]; 
		int[] eng = new int[MAX];
		int[] math = new int [MAX];
		int tot[]= new int [MAX];
		double avg[] = new double [MAX];
		String grade[] = new String[MAX];
		
		int i;
		int cnt = 0;
		double avg_hap = 0;
		
		Scanner scan = new Scanner(System.in);
		
		
		for(i = 0; i < MAX; i++) {
			System.out.print("학번 입력 => ");
			hakbun[i] = scan.next();
			
			if (hakbun[i].equals("exit"))	// exit 입력시 빠져나옴
				break;
			
			System.out.print("이름 입력 => ");
			irum[i] = scan.next();
			
			while(true) {
				try {
					System.out.print("국어점수 입력 => ");
					kor[i] = scan.nextInt();
				}
				catch(Exception e) {
					System.out.println("국어점수 입력 오류 => " + e.getMessage());
					if(scan.hasNext())	//버퍼로부터 읽을 데이터가 있는지 확인하는 메소드 (true, false 반환)
						scan.next();	//잘 못 입력한 점수 비우기
					
					continue;
				}
				break;
			}

			System.out.print("영어점수 입력 => ");
			eng[i] = scan.nextInt();
			System.out.print("수학점수 입력 => ");
			math[i] = scan.nextInt();
			
			tot[i] += kor[i] + eng[i] + math[i];
			avg[i] = tot[i] / 3;
			
			switch ((int)avg[i] / 10) {
			case 10:
			case 9:
				grade[i] = "수";
				break;
				
			case 8: 
				grade[i] = "우";
				break;
			case 7:
				grade[i] = "미";
				break;
			case 6:
				grade[i] = "양";
				break;
			default: 
				grade[i] = "가";
				break;
			}
			cnt++;	//입력 카운트 증가
			System.out.println();
		}
		
		
			System.out.println("\n\t\t *** 성적표 ***");
			System.out.println("===============================================================");
			System.out.println("학번   이름  국어  영어  수학  총점   평균   등급");
			System.out.println("===============================================================");
			for(i = 0; i < 3; i ++) {
				avg_hap += avg[i];
			System.out.printf("%4s   %3s   %3d   %3d   %3d   %3d   %5.2f   %2s\n",
						hakbun[i], irum[i], kor[i], eng[i], math[i], tot[i], avg[i], grade[i]);
			}
			System.out.println("===============================================================");
			System.out.printf("\t 학생수 = %d, 전체 평균 = %5.2f\n", cnt, avg_hap / cnt);
			
			
			
		
	}
}
