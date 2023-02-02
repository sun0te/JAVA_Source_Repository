import java.io.File;
import java.util.GregorianCalendar;

public class FileExample1 {
	public static void main(String args[]) {
		 File file = new File("."); // 현재 디렉토리 경로명을 가지고 File 객체
		 File arr[] = file.listFiles();	//서브디렉토리와 파일 목록을 가져온다
		 
		 // 가져온 서브디렉토리와 파일의 이름, 크기, 최종수정 일시를 출력
		 for (int cnt = 0; cnt < arr.length; cnt++) {
			 String name = arr[cnt].getName(); 
			 if (arr[cnt].isFile())
				 System.out.printf("%-25s %7d ", name, arr[cnt].length());
			 else
				 System.out.printf("%-25s <DIR> ", name);
			 long time = arr[cnt].lastModified(); 
			 GregorianCalendar calendar = new GregorianCalendar();
			 calendar.setTimeInMillis(time);
			 System.out.printf("%1$tF %1$tT %n", calendar);
		 }
	}
}
