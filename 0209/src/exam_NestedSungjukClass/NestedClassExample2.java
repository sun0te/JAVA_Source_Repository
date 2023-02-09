package exam_NestedSungjukClass;

public class NestedClassExample2 {

	public static void main(String[] args) {
		Sungjuk_Inner sungjuk = new Sungjuk_Inner();
		sungjuk.addSungjuk();
		System.out.println();
		sungjuk.addSungjuk();
		System.out.println();
		Sungjuk_Inner.Sungjuk obj = sungjuk.new Sungjuk();
		obj.input();
		obj.process();
		sungjuk.list.add(obj);
		System.out.println();
		printCart(sungjuk);
		
	}
	static void printCart(Sungjuk_Inner sungjuk) {
		int num = sungjuk.getSungjukNum();
		System.out.println("\n\t\t *** 성적표 ***");
	      System.out.println("===============================================================");
	      System.out.println("학번 이름  국어  영어  수학 총점   평균    등급");
	      System.out.println("===============================================================");
		for (int cnt = 0; cnt < num; cnt++) {
			Sungjuk_Inner.Sungjuk obj = sungjuk.getSungjuk(cnt);
			obj.output();
		}
		System.out.println("----------------------------------");
		System.out.printf(" 총 학생 수 : %d, 전체 평군 : %.5.2f \n\n", 
				sungjuk.getSungjukNum(),
				sungjuk.getTotalAvg()/sungjuk.getSungjukNum());

	}

}
