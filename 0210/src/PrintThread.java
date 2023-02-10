//파이를 출력하는 스레드 클래스
class PrintThread extends Thread {
	SharedArea sharedArea; 
	
	public void run() {
		//SharedArea 객체의 isReady 필드 값이 true가 될 때까지 루프를 반복
		while(sharedArea.isReady != true) 
			 continue; 
		System.out.println(sharedArea.result); //공유 영역의 데이터를 출력
	}

}
