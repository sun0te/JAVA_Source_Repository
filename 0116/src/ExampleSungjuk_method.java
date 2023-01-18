
public class ExampleSungjuk_method {
	
	final static int MAX = 100;
	
	public static void main(String[] args) {
		Sungjuk obj[] = new Sungjuk[MAX];	
		//obj.input_Score();
		//obj.process_Score();
		
		int cnt = 0;
		double avg_hap = 0;
			
		cnt = input_sungjuk(obj);
		//int cnt = input_sungjuk(obj);
		output_sungjuk(obj, cnt);
			
	}
	
	static int input_sungjuk(Sungjuk obj[]) {
		
		int cnt = 0;
		
		for(int i =0; i < MAX; i++) {
			obj[i] = new Sungjuk();
			if(obj[i].input_Score())
				break;
			obj[i].process_Score();
			cnt++;
			System.out.println();
		}	
		return cnt;
	}
	
	//파라미터 값을 받을 때 추가할 것 -> int cnt : 입력받은 실제 갯수도 받아야 함
	static void output_sungjuk(Sungjuk obj[], int cnt) {
			
		double avg_hap = 0.0;
		
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("===============================================================");
		System.out.println("학번	이름 	국어  영어  수학 총점   평균    등급");
		System.out.println("===============================================================");
		
		//obj.output_Score();
		for (int i = 0; i < cnt; i++) {
			obj[i].output_Score();
			avg_hap += obj[i].avg;
		}
		
		System.out.println("===============================================================");
		System.out.printf("\t 총 학생수 = %d, 전체 평균 = %5.2f\n", cnt, avg_hap / cnt);
		
	}

}
