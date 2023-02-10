//알파벳을 출력하는 스레드 클래스
public class AlphabetThread extends Thread {
	public void run() {
		 for (char ch = 'A'; ch <= 'Z'; ch++) {
			 System.out.print(ch);
			 try {
				 Thread.sleep(500);
			 } catch (InterruptedException e) {
				 System.out.println(e.getMessage());
			 	}
		 }
	}

}
