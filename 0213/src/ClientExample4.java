import java.net.Socket;

//클라이언트 프로그램 : 송수신 클래스가 각각 존재한다. 
public class ClientExample4 {

	public static void main(String[] args) {
		if (args.length != 1) {
				System.out.println(
				"Usage: java ClientExample4 <user-name>");
				return;
			}
			try {
				Socket socket = new Socket("127.0.0.1",
				9002);
				Thread thread1 = new SenderThread(socket,args[0]);
				Thread thread2 = new ReceiverThread(socket);
				thread1.start();
				thread2.start();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}

}
