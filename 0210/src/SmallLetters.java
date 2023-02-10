//영문 소문자를 출력하는 스레드 클래스
public class SmallLetters implements Runnable {

	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++)
			 System.out.print(ch);
		
		try {
			 Thread.sleep(1000);	//1000은 1초
		 } catch (InterruptedException e) {
			 System.out.println(e.getMessage());
		 }
	}

}
