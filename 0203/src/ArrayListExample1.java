import java.util.ArrayList;

public class ArrayListExample1 {

	public static void main(String args[]) {
		//ArrayList 객체 생성
		ArrayList<String> list = new ArrayList<String>(); 
		list.add("포도"); 
		list.add("딸기"); 
		list.add("복숭아"); 
		int num = list.size(); 
		
		// 리스트에 있는 데이터의 수만큼 루프를 돌면서 데이터를 읽어와서 출력
//	for (int cnt = 0; cnt < num; cnt++) {
//		String str = list.get(cnt); 
//		System.out.println(str);
//	}
		
		for(String str : list) {  //list : Collection 타입 객체
			System.out.println(str);
		}
		
	}

}
