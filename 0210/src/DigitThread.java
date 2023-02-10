//숫자를 출력하는 스레드 클래스
public class DigitThread extends Thread {
	public void run() {
		 for (int cnt = 0; cnt < 10; cnt++)
			 System.out.print(cnt);
		 
		 try { 
			 Thread.sleep(1000); 
		} catch (InterruptedException e) { 
			 System.out.println(e.getMessage()); 
		}
		 
		 }
}
