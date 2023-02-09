package exam_LinkedQueue;

// [실습] 연결 자료구조 방식을 이용하여 구현한 연결 큐 프로그램
interface Queue {
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class QueueNode {
	char data;
	QueueNode link;
}


class LinkedQueue implements Queue{
	 private QueueNode front;
	 private QueueNode rear;
	
	 public LinkedQueue() {
		 front = null;
		 rear = null;
	 }
	 
	public boolean isEmpty() {
		return (front == null);
	}
	
	//정해진 사이즈가 없기 때문에 만들지 않아도 된다.
//	public void isFull() {	
//	}
	
	public void enQueue(char item) {
		QueueNode newNode = new QueueNode();
		newNode.data = item;
		newNode.link = null;
		
		if (isEmpty()) {	//연결 큐가 공백일 경우
			rear = newNode;
			front = newNode;
			
		}
		else {	//연결 큐에 노드가 있는 경우
			rear.link = newNode;
			rear = newNode;
		}
		System.out.println("Inserted item : " + item);
	}
	
	public char deQueue() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
			return 0; 
		}
		else {
			char item = front.data;
			front = front.link;
			if(front == null)	//if(isEmpty()) 도 상관없다
				rear = null;
			return item;
		}
	}
	
	public void delete() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
			
		}
		else {
			front = front.link;
			if(front == null)
				rear = null;
		}
	}
	public char peek() {
		if (isEmpty()) {
			System.out.println("Peeking fail! Array Queue is empty!!");
			return 0;
		}
		else 
			return front.data;
	}
	
	public void printQueue() { //큐 내용을 순서대로 출력 (배열의 내용을 순서대로 출력)
		if (isEmpty()) 
			System.out.printf("Array Queue is empty!! %n%n");
			else {
				QueueNode temp = front;
				System.out.print("Linked Queue >> ");
				while(temp != null) {
					System.out.printf("%c ", temp.data);
					temp = temp.link;
				}
				System.out.println("\n\n");
			}
		}
	
}

public class Ex8_3_LinkedQueue {

	public static void main(String[] args) {
		char deletedItem;
		LinkedQueue  LQ  = new LinkedQueue();
		
		LQ .enQueue('A');
		LQ .printQueue();
		
		LQ .enQueue('B');
		LQ .printQueue();
		
		deletedItem = LQ .deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		LQ .printQueue();
		
		LQ .enQueue('C');
		LQ .printQueue();
		
		deletedItem = LQ .deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		LQ .printQueue();
		
		deletedItem = LQ .deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		LQ .printQueue();
		
		deletedItem = LQ .deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		LQ .printQueue();
		
	}

}
