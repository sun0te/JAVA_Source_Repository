import java.util.ArrayList;

public class LinkedListExample1 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("머루"); 
		list.add("사과"); 
		list.add("앵두"); 
		list.add("자두"); 
		list.add("사과"); 
		
		// 리스트에 있는 첫번째 “사과”와 마지막 “사과”의 인덱스를 가져와서 출력
		int index1 = list.indexOf("사과"); 
		int index2 = list.lastIndexOf("사과"); 
		System.out.println("첫번째 사과: " + index1);
		System.out.println("마지막 사과: " + index2);
	}

}
