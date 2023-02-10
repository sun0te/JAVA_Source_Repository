package critical_section;
//계좌 이체를 수행하는 스레드 클래스
public class TransferThread extends Thread {
	SharedArea sharedArea;
	TransferThread(SharedArea area) { // 생성자
		sharedArea = area;
	}
	public void run() {
		 for (int cnt = 0; cnt < 12; cnt ++) {
			 sharedArea.transfer(100); //계좌 이체 메소드 호출
		 }
	}

}
