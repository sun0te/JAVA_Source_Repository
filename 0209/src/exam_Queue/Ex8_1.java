package exam_Queue;
//선형 큐 실습문제
interface Queue {
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class ArrayQueue implements Queue {
	int front;
	int rear;
	int n;
	char[] Q;
	
	public ArrayQueue(int queueSize) { //crateArray
		n = queueSize;
		Q = new char[n];
		front = -1;
		rear = -1;
	}
	
	public boolean isFull() {
		if(rear == n-1)
			return true;
		else 
			return false;
	}

	public void printQueue() {	//Queue 내용 순서대로 출력(배열의 내용을 순서대로 출력)
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.\n");
			return;
		}
		else {
			System.out.println("큐 출력");
			for(int i = front + 1; i< rear + 1; i++) {
				System.out.println("| "+Q[i]+" |");
			}
			System.out.println();
		}
	}
	
	public boolean isEmpty() {
		if(front == rear)
			return true;
		else 
			return false;
	}
	
	public void enQueue(char item) {
		if (isFull()) {
            System.out.println("큐가 꽉 찼습니다.");
            return;
        }
		else {
			System.out.println("Insert Item : "+item);
			Q[++rear] = item;
		}
	}
	
	public char deQueue() {
		if (isEmpty()) {
            System.out.println("삭제할 큐가 없습니다.");
            return 0;
        }
		else
			return Q[++front];	//뒤로 이동
	}
	
	public void delete() {
		front = rear = -1;
	}
	
	public char peek() {
		if (isEmpty()) {
            System.out.println("검색할 큐가 없습니다.");
            return 0;
        }
		else 
		{
			System.out.print("\n첫 번째 원소 : ");
			return Q[front + 1];
		}
	}
	

}

public class Ex8_1 {

	public static void main(String[] args) {
		int queueSize = 3;
		char deletedItem;
		ArrayQueue Q = new ArrayQueue(queueSize);
		
		Q.enQueue('A');
		Q.printQueue();
		
		Q.enQueue('B');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		Q.printQueue();
		
		Q.enQueue('C');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("delete Item : " + deletedItem);
		Q.printQueue();
		
	}

}
