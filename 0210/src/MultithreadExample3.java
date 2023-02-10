//main 메소드를 포함하는 클래스
public class MultithreadExample3 {

	public static void main(String[] args) {
		Thread thread = new Thread(new SmallLetters()); // 스레드를 생성 
		thread.start(); // 스레드를 시작 
		char arr[] = { 'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 
				'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };
		for (char ch : arr) {
			System.out.print(ch);
		try {
			 Thread.sleep(1000);
		 } catch (InterruptedException e) {
			 System.out.println(e.getMessage());
		 }
		}
	}

}
