import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//메시지를 수신하는 쓰레드 클래스
class ReceiverThread extends Thread {
	Socket socket;
	ReceiverThread(Socket socket) {
	this.socket = socket;
	}
	public void run() {
	try {
		BufferedReader reader = new BufferedReader( //reader 수신객체
		new InputStreamReader(socket.getInputStream()));
		
		while (true) {
				String str = reader.readLine();	//메세지 수신
				if (str == null)
				break;
				System.out.println(str);
		}
	}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
