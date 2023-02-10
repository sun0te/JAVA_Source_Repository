package exam_DoubleEndQueue;
//[실습 과제 답] 단순연결리스트 큐 코드를 이중연결리스트로 변경
//Double End Queue(Deque)

class DQNode {
	char data;
	DQNode rlink;
	DQNode llink;
}

class DQueue {
	DQNode front;
	DQNode rear;

	public DQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	//프론트에 삽입하는 알고리즘?
	public void insertFront(char item) {
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink = null;
			newNode.llink = null;
		}
		else {
			front.llink = newNode;
			newNode.rlink = front;
			newNode.llink = null;
			front = newNode;
		}
		System.out.println("Front Inserted Item : "+item);
	}
	
	public void insertRear(char item) {
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink = null;
			newNode.llink = null;
		}
		else {
			rear.rlink = newNode;
			newNode.rlink = null;
			newNode.llink = rear;
			rear = newNode;
		}
		System.out.println("Rear Inserted Item : "+item);
	}
	
	public char deleteFront() {
		if(isEmpty()) {
			System.out.println("Front Deleting fall! DQueue is empty!");
			return 0;
		}
		else {
			char item = front.data;
			if(front.llink == null) {
				front = null;
				rear = null;
			}
			else {
				front = front.rlink;
				front.llink = null;
			}
			return item;
		}
	}
	
	public char deleteRear() {
		if(isEmpty()) {
			System.out.println("RearDeleting fail! DQueue is empty!");
			return 0;
		}
		else {
			char item = rear.data;
			if(rear.llink == null) {
				rear = null;
				front = null;
			}
			else {
				rear = rear.llink;
				rear.rlink = null;
			}
			return item;
		}
	}
	
	//deleteRear()와 비슷하지만 반환값이 없음
	public void removeFront() {
		if(isEmpty()) {
			System.out.println("RearDeleting fail! DQueue is empty!");
		}
		else {
			if(rear.rlink == null) {
				rear = null;
				front = null;
			}
			else {
				rear = front.llink;
				rear.llink = null;
			}
		}
	}
	
	public void removeRear() {
		if(isEmpty()) {
			System.out.println("RearDeleting fail! DQueue is empty!");
		}
		else {
			if(rear.llink == null) {
				rear = null;
				front = null;
			}
			else {
				rear = front.llink;
				rear.rlink = null;
			}
		}
	}
	
	public char peekFront() {
		if(isEmpty()) {
			System.out.println("Front Peeking fail! DQueue is empty!");
			return 0;
		}
		else 
			return front.data;
	}
	
	public char peerRear() {
		if(isEmpty()) {
			System.out.println("Front Peeking fail! DQueue is empty!");
			return 0;
		}
		else 
			return rear.data;
	}
	
	public void printDQueue() {
		if(isEmpty()) {
			System.out.println("DQueue is Empty! \n\n");
		}
		else {
			DQNode temp = front;
			System.out.printf("DQueue >> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp = temp.rlink;
			}
			System.out.println("\n\n");
		}
	}
	
	
	
}//class DQueue

public class Ex8_3_DoubleEndQueue {

	public static void main(String[] args) {
		char deletedItem;
		DQueue  LQ  = new DQueue();
		
		LQ .insertFront('A');
		LQ .printDQueue();
		
		LQ .insertFront('B');
		LQ .printDQueue();
		
		LQ .insertFront('C');
		LQ .printDQueue();
		
		deletedItem = LQ .deleteFront();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		LQ .printDQueue();

		deletedItem = LQ .deleteFront();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		LQ .printDQueue();
		
		LQ .insertFront('D');
		LQ .printDQueue();
		
		LQ .insertFront('E');
		LQ .printDQueue();
		
		LQ .insertFront('F');
		LQ .printDQueue();
		
		
	}

}
