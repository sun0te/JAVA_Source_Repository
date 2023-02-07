package stack_LinkedList;

interface Stack {
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class StackNode {
	char data;
	StackNode link;
}

class LinkedStack implements Stack{
	private StackNode top; //스텍 포인터
	
	//오버라이딩
	public boolean isEmpty(){ //빈 스텍인지 check
		return (top == null);
	}
	
	
	public void push(char item){	//데이터 삽입
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
		System.out.println("Insert Item : " + item);
	}
	
	public char pop(){	//데이터 삭제(데이터 반환 후)
		if(isEmpty()) {
			System.out.println("데이터가 비어있습니다.");
			return 0;
		}
		else {
			char item = top.data;
			top = top.link;
			return item;
		}
	}
	
	public void delete(){	//데이터만 삭제(반환값 없음)
		if(isEmpty()) {
			System.out.println("데이터가 비어있습니다.");
		}
		else {
			top = top.link;
		}
	}
	
	public char peek(){	//스텍 포인터(top) 위치 데이터 값만 반환
		if(top == null) {
			System.out.println("데이터가 비어있습니다.");
			return 0;
		} 
		else {
			return top.data;
		}
	}
	
	public void printStack(){	//스텍의 내용을 배열에 저장된 순서대로 출력
		if(isEmpty()) {
			System.out.println("데이터가 비어있습니다.");
		}
		else {
			StackNode temp = top;
			System.out.print("Linked Stack >> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp = temp.link;
			}
			System.out.println();
		}
	}
}


public class Ex7_2 {

	public static void main(String[] args) {
		char deletedItem;
		LinkedStack LS = new LinkedStack();
		
		LS.push('A');
		LS.printStack();
		
		LS.push('B');
		LS.printStack();
		
		LS.push('C');
		LS.printStack();
		
		deletedItem = LS.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LS.printStack();		
		System.out.println("peek : " + LS.peek());

	}

}
