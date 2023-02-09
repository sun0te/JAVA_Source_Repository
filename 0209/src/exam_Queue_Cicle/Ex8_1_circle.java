package exam_Queue_Cicle;
//원형 큐 실습문제
interface Queue {
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class ArrayQueue implements Queue{
	 private int front;
	 private int rear;
	 private int queueSize;
	 private char itemArray[];

	public ArrayQueue(int queueSize) {
		front = 0;
		rear = 0;
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
	}
	
	public boolean isEmpty() {
		return (front == rear);
	}
	
	public boolean isFull() {
		return ((rear+1) % this.queueSize == front);
	}
	public void enQueue(char item) {
		if (isFull()) {
			System.out.println("Inserting fail! Array Queue is full!!");
		}
		else {
			rear = (++rear) % this.queueSize;
			itemArray[rear] = item;
			System.out.println("Inserted item : " + item);
		}
	}
	public char deQueue() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
			return 0; 
		}
		else {
			front = (++front) % this.queueSize;
			return itemArray[front];
		}
	}
	public void delete() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
		}
		else {
			front = (++front) % this.queueSize;
		}
	}
	public char peek() {
		if (isEmpty()) {
			System.out.println("Peeking fail! Array Queue is empty!!");
			return 0;
		}
		else 
			return itemArray[(++front) % this.queueSize];
	}
	
	public void printQueue() { //큐 내용을 순서대로 출력(배열의 내용을 순서대로 출력)
		
		//내가 작성한 코드 (i가 계속 증가하기 때문에 인덱스 값이 변화하면 잘 출력이 안됨)
//		if (isEmpty()) 
//			System.out.printf("Array Queue is empty!! %n%n");
//			else {
//				System.out.printf("Array Queue>> ");
//				for(int i = (front + 1)% this.queueSize; i <= rear % queueSize; i++)
//					System.out.printf("%c ", itemArray[i]);
//				System.out.println();
//				System.out.println();
//			}
		
	//답안 코드
		int num;
		num = rear - front;
		if(num < 0)
			num += this.queueSize;
		
		if(isEmpty())
			System.out.println();
		else {
			for(int i = (front+1) % this.queueSize; i != (rear+1) % this.queueSize; i = ++i % this.queueSize)
				System.out.printf("%c ", itemArray[i]);
			System.out.println("\n데이터 수 = "+ num);
			System.out.println();
		}
		
	}
	
}

public class Ex8_1_circle {

	public static void main(String[] args) {
		int queueSize = 4;
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
		
		Q.enQueue('D');
		Q.printQueue();
		
		Q.enQueue('E');
		Q.printQueue();
	}

}
