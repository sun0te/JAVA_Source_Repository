
//서버 프로그램
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);	//서버 소켓 생성
			socket = serverSocket.accept();	//연결 요청 시 소켓 생성
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
			
			String str = "Hello, Client";
			out.write(str.getBytes());
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
			try {
				serverSocket.close();
			}
			catch (Exception ignored) {
			}
		}
	}

}
