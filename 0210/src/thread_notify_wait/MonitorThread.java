package thread_notify_wait;
//다른 스레드를 모니터링하는 스레드 클래스
public class MonitorThread extends Thread {
	Thread thread;
	
	MonitorThread(Thread thread) { // 생성자
		this.thread = thread;
	}
	
	public void run() {
		while (true) {
			Thread.State state = thread.getState(); 
			System.out.println("쓰레드의 상태: " + state);
			if (state == Thread.State.TERMINATED)
				break;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}
}
