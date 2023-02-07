package Exam_HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//해시맵으로 변경
//전체 출력하는 방법 답안 없음

//키 : 사원번호, 값 : 사원 객체

public class HashMapSawon {
	public static void main(String[] args) {
		HashMap<String, Sawon> hashmap = new HashMap<String, Sawon>();
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			printMenu();
			System.out.print("메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();
			
			if (menu == 6) {
				System.out.println("The End...");
				break;
			}
			
			switch (menu)
			{
				case 1:
					input_sawon(hashmap);
					break;
				case 2:
					output_sawon(hashmap);
					break;
				case 3:
					search_sawon(hashmap);
					break;
				case 4:
					update_sawon(hashmap);
					break;
				case 5:
					delete_sawon(hashmap);
					break;
				default: 
				
			}
		}	
	}
	
	static void printMenu()
	{
		System.out.println("*** 사원관리 ***");
		System.out.println("1. 사원정보 입력");
		System.out.println("2. 사원정보 출력");
		System.out.println("3. 사원정보 조회");
		System.out.println("4. 사원정보 수정");
		System.out.println("5. 사원정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}
	
	static void input_sawon(HashMap<String, Sawon>hashmap)
	{
		Sawon obj = new Sawon();
		obj.inputData();
		
		//if(hashmap.get(obj.sabun) != null)
		if(hashmap.containsKey(obj.sabun)) {
			System.out.println("\n번호 입력 오류(중복)\n");
			return;
		}
		hashmap.put(obj.sabun, obj);
		System.out.println("\n사원번호 입력 성공\n");
		
	}
	
	static void output_sawon(HashMap<String, Sawon> hashmap)
	{
		//1. keyset()사용
//		Set<String> keyset = hashmap.keySet();	// hashmap 에 존재하는 키 집합을 구함
//		
//		if (keyset.size() == 0)
//		{
//			System.out.println("출력할 사원정보가 없습니다!!\n");
//			return;
//		}
//		
//		System.out.println("\t      *** 사원정보 ***");
//		System.out.println("============================================");
//		System.out.println("사원번호       부서명         이름         성별                이메일");
//		System.out.println("============================================");
//		for (String sabun : keyset) {
//			Sawon obj = hashmap.get(sabun);
//			obj.outputData();
//		}
//		System.out.println("============================================");
//		System.out.printf("\t\t 총사원수 : %d\n\n", hashmap.size());
		
		
		//2. 
//		Set entryset = hashmap.entrySet();	// hashmap 에 존재하는 키 집합을 구함
//		
//		if (entryset.size() == 0)
//		{
//			System.out.println("출력할 사원정보가 없습니다!!\n");
//			return;
//		}
//		
//		System.out.println("\t      *** 사원정보 ***");
//		System.out.println("============================================");
//		System.out.println("사원번호       부서명         이름         성별                이메일");
//		System.out.println("============================================");
//		Iterator it_entry = entryset.iterator();	//순차적인 접근을 위해 Iterator 객체로 변환
//		while(it_entry.hasNext()) 
//		{
//			//키와 값을 읽기 위해 Map.Entry 로 캐스트 연산
//			Map.Entry e = (Map.Entry) it_entry.next(); 
//			//e.getValue():데이터 값을 읽어 옴, e.getKey() : 키 값을 읽어옴
//			//e.getValue()의 리턴 타입이 Object이므로 Sawon 으로 캐스트 연산
//			Sawon obj = (Sawon)e.getValue();
//			obj.outputData();
//		}
//		System.out.println("============================================");
//		System.out.printf("\t\t 총사원수 : %d\n\n", hashmap.size());

		//3.
		if(hashmap.size() == 0)
		{
			System.out.println("출력사원정보 없음");
			return;
		}
		System.out.println("\t      *** 사원정보 ***");
		System.out.println("============================================");
		System.out.println("사원번호       부서명         이름         성별                이메일");
		System.out.println("============================================");
		
		for(Sawon obj : hashmap.values()) {
			obj.outputData();
		}
		
		System.out.println("============================================");
		System.out.printf("\t\t 총사원수 : %d\n\n", hashmap.size());

	}
	
	static void search_sawon(HashMap<String, Sawon> hashmap)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("조회할 사원번호 입력 => ");
		String sabun = scan.next();
		
		Sawon obj = hashmap.get(sabun);
		
		if(obj != null) {
			if (sabun.equals(obj.sabun)) {
				System.out.println("\n사원번호       부서명         이름         성별                이메일");
				System.out.println("============================================");
				obj.outputData();
				System.out.println("============================================\n");
				return;
			}	
		}
		System.out.println("\n조회할 사원번호 입력 오류!!\n");
	}
	
	static void update_sawon(HashMap<String, Sawon> hashmap)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("수정할 사원번호 입력 => ");
		String sabun = scan.next();
		
		Sawon obj = hashmap.get(sabun);
			if (obj != null) {
				System.out.print("부서명 입력 => ");
				obj.deptname = scan.next();
				System.out.print("이름 입력 => ");
				obj.irum = scan.next();
				System.out.print("성별 입력 => ");
				obj.gender = scan.next();
				System.out.print("이메일 입력 => ");
				obj.email = scan.next();
				System.out.println("\n사원정보 수정 성공!!\n");
				return;
			}	
		System.out.println("\n수정할 이름 입력 오류!!\n");
	}
	
	static void delete_sawon(HashMap<String, Sawon> hashmap)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 사원번호 입력 => ");
		String sabun = scan.next();
		
		Sawon obj = hashmap.get(sabun);
		if (obj != null) {
			hashmap.remove(sabun);
			System.out.println("\n사원정보 삭제 성공!!\n");
			return;
		}	
		
		System.out.println("\n삭제할 사원번호 입력 오류!!\n");
	}
}
