package thread_notify_wait;
//[예제 18-18] 모니터링 스레드가 추가된 원주율 계산 프로그램
//[CalcThread를 모니터링하도록 수정된 예제 18-18]
public class MultithreadExample9 {

	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		//MonitorThread thread3 = new MonitorThread(thread1); 
		MonitorThread thread3 = new MonitorThread(thread2);
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
