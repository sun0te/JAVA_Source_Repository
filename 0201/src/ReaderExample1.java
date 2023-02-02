import java.io.*;

public class ReaderExample1 {

	public static void main(String[] args) {
		// FileReader reader = new FileReader("poem.txt"); try 안의 코드를 밖으로 빼내어 반복할 수 있게 설계
		FileReader reader = null;
		//예외처리 없을 시 오류!
		try { 
			reader = new FileReader("poem.txt"); //파일 여는 부분
		// 파일을 읽어서 처리하는 부분 
			while (true) {
			 int data = reader.read(); 
			 if (data == -1)
			 break;
			 char ch = (char) data;
			 System.out.print(ch);
			 }
			 reader.close(); //파일 닫는 부분
		}
		//FileReader의 생성자가 발생하는 익셉션을 처리
		catch (FileNotFoundException fnfe) { 
			System.out.println("파일이 존재하지 않습니다."); 
			 } 
		// FileReader의 read, close 메소드가 발생하는 익셉션을 처리
		catch (IOException ioe) { 
			System.out.println("파일을 읽을 수 없습니다."); 
		 }
		finally {
			 try { 
			 reader.close(); // 파일을 닫는 명령문을 finally 블록으로 이동
			 } 
			 catch (Exception e) { // close 메소드가 발생하는 익셉션을 처리
			 } 
		}

	}

}
