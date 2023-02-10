//메시지를 송신하는 쓰레드 클래스
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket socket;
	ReceiverThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(
			new InputStreamReader(socket.getInputStream()));
			while (true) {
				String str = reader.readLine();	//수신
			if (str == null)
				break;
			System.out.println("수신>" + str);	//화면출력
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
