
public class ExampleSungjuk_method {
	
	final static int MAX = 100;
	
	public static void main(String[] args) {
		Sungjuk obj[] = new Sungjuk[MAX];	
		
		input_sungjuk(obj);
		output_sungjuk(obj);
		
	}
	
	static void input_sungjuk(Sungjuk obj[]) {
		
		for(int i =0; i < MAX; i++) 
		{
			obj[i] = new Sungjuk();
			if(obj[i].input_Score())
				break;
			obj[i].process_Score();
			Sungjuk.cnt++;
			System.out.println();
		}	
	}
	

	static void output_sungjuk(Sungjuk obj[]) {
		
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("===============================================================");
		System.out.println("학번	이름 	국어  영어  수학 총점   평균    등급");
		System.out.println("===============================================================");
		
		//obj.output_Score();
		for (int i = 0; i < Sungjuk.cnt; i++) {
			obj[i].output_Score();
			Sungjuk.tot_avg += obj[i].avg;
		}
		
		System.out.println("===============================================================");
		System.out.printf("\t 총 학생수 = %d, 전체 평균 = %5.2f\n", Sungjuk.cnt, Sungjuk.getTotalAvg());
		
	}

}
