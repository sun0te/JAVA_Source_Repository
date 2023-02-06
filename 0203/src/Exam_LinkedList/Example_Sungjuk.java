package Exam_LinkedList;
import java.util.Scanner;
/*
	[문제] 데이터 입력, 출력, 검색, 삭제 기능을 single linkedlist 로 구현하시오
	
	<처리조건>
	1. 데이터 입력 시 학번(bunho) 중복 입력을 허용하지 않는다.
	2. 데이터 입력 시 마지막 추가를 하도록 한다.
	3. 데이터 검색 및 삭제 시 학번을 입력받아 해당 학번에 대한 데이터를 검색하여 출력하거나 삭제한다.  (해당 학번이 없으면 없다고 출력)
*/
//단순 연결 리스트로 수행 -> 단점 : 후속 노드에서 선행노드로 이동할 수 있는 방법이 없다.
//실습  : 단순 연결 리스트 코드 → 원형 연결 리스트로 변경 (과제)
public class Example_Sungjuk implements Cloneable{
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		LinkedList L = new LinkedList();
		Sungjuk data;
		int menu;
		
		do {
			print_menu();
			System.out.println("\n 메뉴 선택 =>");
			menu = in.nextInt();
			
			if(menu == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
			switch (menu)
			{
			case 1:
				System.out.println();
				data = new Sungjuk();
				
				System.out.println("번호 입력 => ");
				data.setBunho(in.nextInt());
				System.out.println("이름 입력 => ");
				data.setIrum(in.next());
				System.out.println("점수 입력 => ");
				data.setJumsu(in.nextInt());
				L.insertLastNode(data);
				break;
			case 2:
				L.printList();
				break;
			case 3:
				System.out.println();
				data = new Sungjuk();
				System.out.print("검색할 번호 입력 => ");
				data.setBunho(in.nextInt());
				L.searchNode(data);
				break;
			case 4:
				System.out.println();
				data = new Sungjuk();
				System.out.println("삭제할 번호를 입력 => ");
				data.setBunho(in.nextInt());
				L.deleteNode(data);
				break;
			default:
				System.out.println("\n메뉴를 다시 입력하세요!\n");
				break;
			}
			
		} while(true);

	}

	static void print_menu() {
		System.out.println("\n*** 메뉴 ***\n");
		System.out.println("1. 데이터 입력\n");
		System.out.println("2. 데이터 출력\n");
		System.out.println("3. 데이터 검색\n");
		System.out.println("4. 데이터 삭제\n");
		System.out.println("5. 프로그램 종료\n");
	}
}




class LinkedList {
		private ListNode head; //head node 객체 주소를 저장 (데이터는 비어져 있다, 첫 번째 노트 주소)
		
		public LinkedList(){
			head = null;
		}
		
		public void insertLastNode(Sungjuk data) { //데이터 입력
			ListNode newNode = new ListNode(data);
			ListNode pre = null;	//탐색한 노드에서 바로 이전 노드를 가르키는 포인터
			Sungjuk obj = null;
			
			if(head == null) {	//빈 리스트
				this.head = newNode; //newNode -> Sungjuk 객체 가리킴, 삽입 후 newNode 사라짐)
				System.out.println("\n삽입 성공!");
			}
			ListNode temp = head;
			
			while(temp != null) {	//번호 중복 데이터 체크
				obj = temp.getData();	//성적 객체를 읽어서 저장
				if(data.getBunho() == obj.getBunho()) {	// 성적 객체는 getBunho() 를 저장
					System.out.println("\n입력 오류 : 존재하는 번호입니다\n");
					return;
				}
				pre = temp;	//temp 바로 이전 노드를 가리킴
				temp = temp.link;	// 리스트의 끝에 들어오면 temp = null 로 대입됨 중복 검사 끝

			}//while
			
			//pre를 추가하여 낭비되는 메소드 하나 제거 가능
//			temp = head;
//			while(temp.link != null)	//마지막 노드인지 확인
//				temp = temp.link;	//마지막 노드 아니면 다음 노드로 넘어감
			
//			temp.link = newNode; // newNode -> temp.link에 대입 (마지막 노드와 연결)
			pre.link = newNode;
			System.out.println("\n삽입 성공!");
			
		}
		
		public void printList() { //전체 데이터 출력, 데이터 없을 때 메시지
			ListNode temp = this.head;
			
			if(this.head == null) {
				System.out.println("입력한 정보가 없습니다. 데이터를 입력해주세요");
				return ;
			}
			System.out.println();
			System.out.println("번호\t이름\t점수");
			System.out.println("---------------------");
			
			while(temp != null) {
				Sungjuk data = temp.getData();	//성적 객체 불러오기
				//System.out.printf("%3d	%3s %4d %n", data.getBunho(), data.getIrum(), data.getJumsu());	//성적 클래스에 메소드
				data.printData();
				temp = temp.link;	//temp에 다음 노드 주소값 저장
			}
			System.out.println("---------------------");
			
		}
		
		public void searchNode(Sungjuk data) {  //번호를 가지고 배열 내에서 동일한 번호를 가진 성적 객체 찾기		  
			ListNode temp = this.head;
			Sungjuk obj = null;
			
			if(this.head == null) {
				System.out.println("\n리스트에 데이터가 없습니다.\n");
				return;
			}
			System.out.println();
			
			while(temp != null){
				obj = temp.getData();
				if(data.getBunho() == obj.getBunho()) {
					System.out.println();
					System.out.println("번호\t이름\t점수");
					System.out.println("---------------------");
					obj.printData();
					return;
				}
				else 
					temp = temp.link;
				
			} //수정
			System.out.println("일치하는 번호가 없습니다.");
		}
		
		public void deleteNode(Sungjuk data) {  //삭제
			ListNode pre, temp;
			Sungjuk obj = null;
			
			if(this.head == null) {	//빈 리스트일 때
				System.out.println("\n현재 리스트에 데이터가 없습니다.\n");
				return;
			}
			
			if(this.head.link == null) {	//리스트에 노드가 한 개만 있는 경우
				temp = this.head;
				obj = temp.getData();
				if(data.getBunho() == obj.getBunho()) {	//첫번째 노드의 번호와 일치하는 경우
					System.out.println("삭제가 되었습니다.");
					head = null;	//리스트의 시작 포인터를 null 로 설정, 첫 노드와 연결끊어짐
					return;
				}
				else {	//노드 한 개인데 일치하지 않을 때
					System.out.println("\n삭제오류 - 일치하는 번호가 없습니다.\\n");
				}
			}
			else {	//리스트에 노드가 여러 개 있는 경우
				temp = this.head;
				obj = temp.getData();
				if(data.getBunho() == obj.getBunho()) //노드가 여러 개일때 첫 번째 노드가 삭제할 노드인 경우
				{
					System.out.println("\n삭제가 되었습니다.\n");
					this.head = this.head.link;	//삭제한 노드의 후속 노드 주소를 선행 노드의 링크에 저장(연결), head.link 대신 temp.link 를 사용해도 된다.
					return;
				}
				else {	//노드가 여러 개일때 첫 번째 노드가 아닌 노드를 삭제할 경우
					pre = head;	//첫 번째 노드의 주소 저장
					temp = head.link;	//두 번째 노드의 주소 저장
					while(temp != null) {
						obj = temp.getData();
						if(data.getBunho() == obj.getBunho()) 
						{
							System.out.println("\n삭제가 되었습니다.\n");
							pre.link = temp.link;	// 후속 노드의 주소를 선행 노드의 링크에 저장
							return;
						}
						else	//해당 번호가 아닐 시 후속 노드로 이동
						{
							pre = temp;
							temp = temp.link;
						}
					}//while
				}//else(노드 여러 개 중 첫번 째 아닌 노드 삭제)
				System.out.println("\n삭제오류 - 일치하는 번호가 없습니다.\n");
			}//else (노드 여러개)
		
		}//deleteNode()
		
}//클래스 LinkedList

	class Sungjuk {
		private int bunho; //직접 접근 못 함
		private String irum;
		private int jumsu;
		
		//아래의 메소드를 통해 접근 가능 -> 접근자
		public int getBunho() {
			return bunho;
		}
		public void setBunho(int bunho) {
			this.bunho = bunho;
		}
		public String getIrum() {
			return irum;
		}
		public void setIrum(String irum) {
			this.irum = irum;
		}
		public int getJumsu() {
			return jumsu;
		}
		public void setJumsu(int jumsu) {
			this.jumsu = jumsu;
		}
		
		public void printData() {
			System.out.printf("%3d	%3s	%4d %n", this.bunho, this.irum, this.jumsu);
		}
		
		
	}// class Sungjuk
	
	class ListNode{ 
		
		private Sungjuk data;	
		public ListNode link;
		
		public ListNode(){
			this.data = null;
			this.link = null;
		}
		
		public ListNode(Sungjuk data){
			this.data = data;
			this.link = null;
		}
		public ListNode(Sungjuk data, ListNode link){
			this.data = data;
			this.link = link;
		}
		//데이터가 private 되어있어 직접 값을 못읽기 때문에 getData()를 만들었다.
		public Sungjuk getData(){	
			return this.data;
		}
		
	}//class ListNode
	