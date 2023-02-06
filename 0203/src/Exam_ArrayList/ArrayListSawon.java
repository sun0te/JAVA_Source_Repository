package Exam_ArrayList;
import java.util.Scanner;

public class ArrayListSawon {

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		Sawon data;
		int menu;
		
		do {
			print_menu();
			System.out.println("\n 메뉴 선택 =>");
			menu = in.nextInt();
			
			if(menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			switch (menu)
			{
			case 1:
				System.out.println();
				data = new Sawon();
				System.out.println("사원번호 입력 => ");
				data.setSabun(in.nextInt());
				System.out.println("부서 입력 => ");
				data.setDeptname(in.next());
				System.out.println("이름 입력 => ");
				data.setIrum(in.next());
				System.out.println("성별 입력 => ");
				data.setGender(in.next());
				System.out.println("이메일 입력 => ");
				data.setEmail(in.next());
				arr.insertLastNode(data);
				break;
			case 2:
				arr.printList();
				break;
			case 3:
				System.out.println();
				data = new Sawon();
				System.out.print("조회할 사원번호 입력 => ");
				data.setSabun(in.nextInt());
				arr.searchNode(data);
				break;
			case 4:
				System.out.println();
				data = new Sawon();
				System.out.println("수정할 사원번호를 입력 => ");
				data.setSabun(in.nextInt());
				arr.ModifyNode(data);
				break;
			case 5:
				System.out.println();
				data = new Sawon();
				System.out.println("삭제할 사원번호를 입력 => ");
				data.setSabun(in.nextInt());
				arr.deleteNode(data);
			default:
				System.out.println("\n메뉴를 다시 입력하세요!\n");
				break;
			}
			
		} while(true);

	}

	static void print_menu() {
		System.out.println("\n*** 메뉴 ***");
		System.out.println("1. 사원정보 입력");
		System.out.println("2. 사원정보 출력");
		System.out.println("3. 사원정보 검색");
		System.out.println("4. 사원번호 수정");
		System.out.println("5. 사원번호 삭제");
		System.out.println("6. 프로그램 종료");
	}
}

	class ArrayList {
		static int MAX = 10;
		static int cnt = 0;
		Sawon arr[];
		
		ArrayList() {
			this.arr = new Sawon[MAX];
		}
		
		
		public void insertLastNode(Sawon data) { //데이터 입력, 최대 10회			
			if(this.cnt == MAX) {
				System.out.println("\n [error]메모리 풀!");
				return;
			}
			this.arr[this.cnt++] = data;
			System.out.println("\n 데이터 삽입 성공");
			
		}
		
		public void printList() { //전체 데이터 출력, 데이터 없을 때 메시지
			
			if(this.arr.length == 0) {
				System.out.println("출력할 데이터 없습니다.");
				return ;
			}
			System.out.println();
			System.out.println("사원번호\t 부서명\t 이름\t 성별\t 이메일");
			System.out.println("---------------------");
			for(int i = 0; i < this.cnt; i++) {
				System.out.println(
						    this.arr[i].getSabun() + "\t" 
	    				  + this.arr[i].getDeptname() + "\t   " 
	    				  + this.arr[i].getIrum() + "\t" 
	    				  + this.arr[i].getGender() + "\t"
	    				  + this.arr[i].getEmail() + "\t");
			}
		}
		
		public void searchNode(Sawon data) {  //번호를 가지고 배열 내에서 동일한 번호를 가진 성적 객체 찾기, 출력양식			  
			  for(int i = 0; i < this.cnt; i++) {
				  if(data.getSabun() == this.arr[i].getSabun()) {
					  System.out.println();
					  System.out.println("사원번호\t 부서명\t 이름\t 성별\t 이메일");
				      System.out.println("---------------------");
				      System.out.printf("%3d, %3s, %3s, %2s, %30s \n"
				    		  		, this.arr[i].getSabun() + "\t" 
				    				  + this.arr[i].getDeptname() + "\t   " 
				    				  + this.arr[i].getIrum() + "\t" 
				    				  + this.arr[i].getGender() + "\t"
				    				  + this.arr[i].getEmail() + "\t");
				  }
			  }
			  System.out.println("검색할 데이터가 없습니다.");
		}
		
		public void ModifyNode(Sawon data) {	//데이터 수정
			for(int i = 0; i < this.cnt; i++) {
				  if(data.getSabun() == this.arr[i].getSabun()) {
					  System.out.println();
					  
				  }
			  }
			  System.out.println("수정할 데이터가 없습니다.");
		}
		
		public void deleteNode(Sawon data) {  //삭제하면 이전 데이터 이동, cnt개수 1 감소
			for(int i = 0; i < this.cnt; i++) {
				if(data.getSabun() == this.arr[i].getSabun()) {
					for(int k = i; k < this.cnt -1; k++) {
						this.arr[k] = this.arr[k+1];
					}
					this.cnt--;  
					// 데이터의 접근 범위는 결국 이동된 인덱스 위치까지 줄어든다 
					// ex)4->3으로 이동하면 범위가 4에서 3으로 됨, 결국 이동후 범위가 끝
					System.out.println("\n삭제 성공!!\n");
					return;
				}
			}
			System.out.println("삭제할 데이터가 없습니다.");
		}
		
	}
	
class ListNode{ 
		
		private Sawon data;	
		public ListNode link;
		
		public ListNode(){
			this.data = null;
			this.link = null;
		}
		
		public ListNode(Sawon data){
			this.data = data;
			this.link = null;
		}
		public ListNode(Sawon data, ListNode link){
			this.data = data;
			this.link = link;
		}
		//데이터가 private 되어있어 직접 값을 못읽기 때문에 getData()를 만들었다.
		public Sawon getData(){	
			return this.data;
		}
		
	}//class ListNode
