
public class SystemExample5 {

	public static void main(String[] args) {
		long time1 = System.currentTimeMillis(); //현재 시간 측정
		
		//원주율 근사값 계산
		double total = 0.0;
		for (int cnt = 1; cnt < 1000000000; cnt += 2)
		if (cnt / 2 % 2 == 0)
		total += 1.0 / cnt;
		else
		total -= 1.0 / cnt;
		double pi = total * 4;
		
		//현재시간 측정
		long time2 = System.currentTimeMillis(); 
		System.out.println("result = " + pi);
		System.out.printf("계산에 %d ms가 소요되었습니다.", time2 - time1);

	}

}
