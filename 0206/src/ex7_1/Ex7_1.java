package ex7_1;
//과제 ArrayStack 클래스의 메소드 기능 구현
interface Stack {
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class ArrayStack implements Stack{
	private int top;
	private int stackSize; 
	private char itemArray[];
	
	public ArrayStack(int stackSize){
		top = -1;
		this.stackSize = stackSize;
		itemArray = new char[this.stackSize];
	}
	//오버라이딩
	public boolean isEmpty(){ //빈 스텍인지 check
		return (top == -1);
	}
	
	public boolean isFull(){ //가득찬 스텍인지 check
		return (top == stackSize-1);
	}
	
	public void push(char item){	//데이터 삽입
		if(isFull())
			System.out.println("삽입 에러 - 스텍이 꽉 찼습니다.");
		else{
			itemArray[++top] = item;
			System.out.println("삽입 스텍: " + item);
		}
	}
	
	public char pop(){	//데이터 삭제(데이터 반환 후)
		if(isEmpty()){
			System.out.println("삭제 에러 - 삭제할 스텍이 없습니다. ");
			return 0;
		}else{
			return itemArray[top--];
		}
	}
	
	public void delete(){	//데이터만 삭제(반환값 없음)
		if(isEmpty()){
			System.out.println("삭제 에러 - 삭제할 스텍이 없습니다. ");
		}else{
			--top;
		}
	}
	
	public char peek(){	//스텍 포인터(top) 위치 데이터 값만 반환
		if(isEmpty()){
			System.out.println("서치 에러 - 찾는 스텍이 없습니다. ");
			return 0;
		}else{
			return itemArray[top];
		}
	}
	
	public void printStack(){	//스텍의 내용을 배열에 저장된 순서대로 출력
		if(isEmpty()){
			System.out.println("스텍이 비어있습니다. %n %n");
		}else{
			System.out.println("스텍 출력 > ");
			for(int i=0; i<=top; i++){
				System.out.println(itemArray[i] + " ");
			}
			System.out.println();
		}
	}
}

public class Ex7_1 {
	public static void main(String args[]){
		int stackSize = 5;
		char deletedItem;
		ArrayStack S = new ArrayStack(stackSize);
		
		S.push('A');
		S.printStack();
		
		S.push('B');
		S.printStack();
		
		S.push('C');
		S.printStack();
		
		deletedItem = S.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		S.printStack();		
		System.out.println("peek : " + S.peek());
	}
}

