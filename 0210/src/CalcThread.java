//파이를 계산하는 스레드 클래스
class CalcThread extends Thread {
	SharedArea sharedArea; 
	public void run() {
		double total = 0.0;
		for (int cnt = 1; cnt < 600000; cnt += 2) //작동시간 오래걸려서 범위바꿈
			if (cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		sharedArea.result = total * 4; //계산 결과를 공유 영역
		sharedArea.isReady = true; //SharedArea 객체의 isReady 핃드 값을 true로 설정
	}
}
