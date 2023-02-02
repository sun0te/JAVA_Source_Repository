import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDump {
	public static void main(String args[]) {
		 if (args.length < 1) {
			 System.out.println("Usage: java FileDump <filename>");
			 return;
		 }
		 FileInputStream in = null;
		 try {
			 in = new FileInputStream(args[0]); //오픈한 파일 객체로 저장
			 byte arr[] = new byte[16];	// 파일로부터 16바이트씩 읽기
			 while (true) {
				 int num = in.read(arr); 
				 if (num < 0)
				 break;
				 
				 // 읽어들인 바이트 데이터를 16진수로 출력
				 for (int cnt = 0; cnt < num; cnt ++)
					System.out.printf("%02X ", arr[cnt]);
				 	System.out.println();
			 }
		}
		 catch (FileNotFoundException fnfe) {
			 System.out.println(args[0] + " 파일이 존재하지 않습니다.");
		 }
		 catch (IOException ioe) {
			 System.out.println(args[0] + " 파일을 읽을 수 없습니다.");
		 }
		 finally {
			 try {
			 in.close(); 
			 } 
			 catch (Exception e) {
			 }
		 }
	}

}
