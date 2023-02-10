
public class MultithreadExample2 {
//main 메소드를 포함하는 클래스
	public static void main(String[] args) {
		Thread thread1 = new DigitThread(); 
		Thread thread2 = new DigitThread(); 
		Thread thread3 = new AlphabetThread(); 
		thread1.start(); 
		thread2.start(); 
		thread3.start(); 
	}

}
