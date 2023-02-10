
//클라이언트 프로그램
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample1 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1" , 9000); //소켓 생성
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			String str = "Hello, Server";
			out.write(str.getBytes());
			
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close(); //소켓 닫기
			}
			catch (Exception e) {
			}
		}
	}

}
