package Example_Node;

public class Ex6_2 {
	public static void main(String[] args) {
		LinkedList L = new LinkedList();	//L 객체 생성, 필드 : head(null)
		
		System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
		L.insertLastNode("월");
		L.insertLastNode("수");
		L.insertLastNode("일");
		L.printList();

		System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
		
		ListNode pre = L.searchNode("수");
		if(pre == null)
			System.out.println("검색실패>> 찾는 데이터가 없습니다.");
		else{
			L.insertMiddleNode(pre, "금");
			L.printList();
		}
		
		System.out.println("(3) 리스트의 노드를 역순으로 바꾸기");
		L.reverseList();
		L.printList();
		
		System.out.println("(4) 리스트의 마지막 노드 삭제하기");
		L.deleteLastNode();
		L.printList();
		
		System.out.println("(5) 리스트의 중간 노드 삭제하기");
		L.deleteMiddleNode("금");
		L.printList();
		
		System.out.println("(6) 리스트의 첫 번째 노드 삭제하기");
		L.deletefirstNode("일");
		L.printList();

	}
}
	
class LinkedList{	
	private ListNode head; //head node 객체 주소를 저장 (데이터는 비어져 있다, 첫 번째 노트 주소)
	
	public LinkedList(){
		head = null;
	}
	
	//중간 노드 삽입
	public void insertMiddleNode(ListNode pre, String data){
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	
	//마지막 노드 삽입
	public void insertLastNode(String data){
		ListNode newNode = new ListNode(data);	// data 값을 받아서 Node 생성 (newNode 객체가 100을 가르킴 -> ["월" | 100])
		if(head == null){
			this.head = newNode;	// 수행이 끝나서 newNode 객체 사라짐 100번지 ["월" | null], head 100 -> ["월" | ]
		}
		else{// ["수" | 200]
			ListNode temp = head;	//temp [100] -> 100 [월|null]
			while(temp.link != null) temp = temp.link;	//100[월 | 200]-> [수 | null]
			temp.link = newNode;
		}
	}
	
	//마지막 노드 삭제
	public void deleteLastNode(){
		ListNode pre, temp;
		if(head == null) return;
		
		if(head.link == null){
			head = null;
		}
		else{
			pre = head;
			temp = head.link;
			
			while(temp.link != null){
				pre = temp;
				temp = temp.link;
				}
			pre.link = null; // pre 가 가르키는 노드의 link 값을 없앰(맨 마지막 연결된 노드의 연결이 끊어짐)
			// 연결이 끊어지면 사라짐: 참조되는 레퍼런스가 없으면 자동으로 없어진다.
		}
	}
	
	public void deleteMiddleNode(String data) {
		ListNode pre, temp;
		if(head == null)
			return;
		
		//노드가 한 개일 때 확인
		if(head.link == null) {	//head가 가르키는 링크가 없는지 확인(마지막인지)
			if(head.getData() != data) //head가 가르키는 링크의 데이터(첫 번째)
				return;
			else
				head = null;	
		}
		else {
			pre = head;
			temp = head.link;
			while(temp.getData() != data) { // 두번째부터 비교한다
				pre = temp;	//pre = head가 가르키는 노드의 다음 노드를 가르킴
				temp = temp.link; //temp가 가르키는 노드의 다음 노드를 가르킴
			}
			pre.link = temp.link; //일치하는데이터가 나오면 temp 를 pre에 대입(덮어쓰기)
		}

	}
	
	public void deletefirstNode(String data) { //첫 번째 노드도 삭제할 수 있는 기능 추가
		ListNode pre, temp;
		if(head == null)
			return;
		//노드가 한 개일 때 확인
		if(head.link == null) {	
			if(head.getData() != data) 
				return;
			else
				head = null;	
		}
		else {
			temp = head;
			if(temp.getData() != data) { 
				do {
					pre = temp;
					temp = temp.link;
					if(temp == null)	//temp 가 null 확인, 안 넣으면 오류
						break;
				} while(temp.getData() != data); 
					if(temp != null)	//temp 가 null 인지 확인, 안 넣으면 오류
						pre.link = temp.link;
			}
			else {
				head = temp.link;
			}
			
		}
		
	}
		
	public ListNode searchNode(String data){
		ListNode temp = this.head;
		while(temp != null){
		if(data == temp.getData())
			return temp;
		else temp = temp.link; //data == temp.getData() 일치하지 않을 시 링크 변경
		}
		return temp;
	}
		
	public void reverseList() {
		ListNode next = head;	//다음 노드
		ListNode current = null; // 현재노드
		ListNode pre = null; // 이전 노드
		
		while(next != null){
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}

	public void printList(){
		ListNode temp = this.head;
		System.out.printf("L = (");
		while(temp != null){
			System.out.printf(temp.getData());
			temp = temp.link;
			
			if(temp != null){
				System.out.printf(", ");
			}
		}
		System.out.println(")");
	}
}// class LinkedList

class ListNode{ //노드(Node)
	
	private String data;	//데이터를 직접 저장하지 않는다
	public ListNode link;
	
	public ListNode(){
		this.data = null;
		this.link = null;
	}
	
	public ListNode(String data){
		this.data = data;
		this.link = null;
	}
	public ListNode(String data, ListNode link){
		this.data = data;
		this.link = link;
	}
	//데이터가 private 되어있어 직접 값을 못읽기 때문에 getData()를 만들었다.
	public String getData(){	
		return this.data;
	}
	
}//class ListNode

		
		
		
