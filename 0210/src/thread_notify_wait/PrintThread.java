package thread_notify_wait;
//파이를 출력하는 스레드 클래스
class PrintThread extends Thread {
	SharedArea sharedArea; 
	
	public void run() {
		
		if (sharedArea.isReady != true) { //신호를 받습니다
			 try { 
				 synchronized (sharedArea) { 
					 sharedArea.wait(); 
				 } 
			 } 
			 catch (InterruptedException e) { 
				 System.out.println(e.getMessage()); 
			 } 
		} 
		System.out.println(sharedArea.result); //공유 영역의 데이터를 출력
	}

}
