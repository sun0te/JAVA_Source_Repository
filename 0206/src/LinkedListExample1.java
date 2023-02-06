//import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample1 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>(); 
		list.add("포도"); 
		list.add("딸기"); 
		list.add("복숭아"); 
		int num = list.size();
		
//		for (int cnt = 0; cnt < num; cnt++) {
//		String str = list.get(cnt);
//		System.out.println(str);
//		}
		
		//한꺼번에 모든 데이터를 다룰 때는 향상된 for문이 좋다.
		for(String str:list) 
			System.out.println(str);

		//리스트 : LinkedList 클래스 - 향상된 for문과 동작 방식은 비슷하다.
//		Iterator<String> iterator = list.iterator(); 
//		while (iterator.hasNext()) { 
//		String str = iterator.next(); 
//		System.out.println(str); }

		
	}

}
