import java.net.Socket;
//클라이언트 프로그램
public class ClientExample3 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
		socket = new Socket("127.0.0.1", 9001);
		Thread thread1 = new SenderThread(socket);	//송신쓰레드
		Thread thread2 = new ReceiverThread(socket);//수신쓰레드
		thread1.start();
		thread2.start();
		}
		catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}

}
