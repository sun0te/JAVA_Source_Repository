import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateFormatExample1 {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초"); 
		//뉴욕에 해당하는 TimeZone 객체를 가지고 setTimeZone 메소드를 호출
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York")); 
		//GregorianCalendar 객체를 Date 객체로 만들어서 format 메소드를 호출
		String str = dateFormat.format(calendar.getTime()); 
		System.out.println(str);

	}

}
