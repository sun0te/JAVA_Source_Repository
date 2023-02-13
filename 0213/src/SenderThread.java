import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 메시지를 송신하는 쓰레드 클래스

class SenderThread extends Thread {
	Socket socket;
	String name;
	SenderThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(	//reader : 메시지 입력
			new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); //writer : 메세지 송신
			
			writer.println(name);	
			writer.flush();
			
			while (true) {
				String str = reader.readLine();	//키보드입력
				if (str.equals("bye"))
					break;
				writer.println(str);//송신
				writer.flush();
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch (Exception ignored) {
			}
		}
	}//run()
}
