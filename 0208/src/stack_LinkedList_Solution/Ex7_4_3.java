package stack_LinkedList_Solution;
import java.util.Scanner;

interface Stack{
	boolean isEmpty();
	void push(int item);
	int pop();
	void delete();
	int peek();
}

class StackNode{
	int data;
	StackNode link;
}

class LinkedStack implements Stack{
	private StackNode top;
	
	public LinkedStack(){	
	}
	
	public boolean isEmpty(){ // 빈 스택인지 체크
		return (top == null);
	}
	
	public void push(int item){ // 데이터 삽입
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
//		System.out.println("Inserted Item : " + item);
	}
	
	public int pop(){  // 데이터 삭제(데이터 반환후)
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			int item = top.data;
			top = top.link;
			return item;	
		}				
	}
	
	public void delete(){ // 데이터만 삭제(반환값 없음)
		if(isEmpty()){
			System.out.println("Deleting fail! Linked Stack is empty!!");			
		}
		else {
			top = top.link;
		}
	}
	
	public int peek(){ // 스택 포인터(top)위치 데이터 값만 반환
		if(isEmpty()){
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}
		else 
			return top.data;	
	}
	
	public void printStack(){ // 스택의 내용을 배열에 저장된 순서대로 출력
		if(isEmpty())
			System.out.printf("Linked Stack is empty!! %n %n");
		else{
			StackNode temp = top;
			System.out.println("Linked Stack>> ");
			while(temp != null){
				System.out.printf("%c  ", temp.data);
				temp = temp.link;
			}
			System.out.println();	
		}
	}
}

class OptExp{
	private String exp;
	private int expSize;
	private char testCh, openPair;
	
	public boolean testPair(String exp){
		this.exp = exp;
		LinkedStack S = new LinkedStack();
		expSize = this.exp.length();
		for(int i=0; i<expSize; i++){
			testCh = this.exp.charAt(i);
			switch(testCh){
				case '(' :
				case '{' :
				case '[' : 
					S.push(testCh); 
					break;				
				case ')' :
				case '}' :
				case ']' : 
					if(S.isEmpty()) 
						return false;
					else{
						openPair = (char)S.pop();
						if((openPair == '(' && testCh != ')') ||
						   (openPair == '{' && testCh != '}') ||
						   (openPair == '[' && testCh != ']'))
						   return false;
					    else 
						   break;
					}
			}
		}
		if (S.isEmpty()) 
			return true;
		else 
			return false;
	}
	
	public String infixTopostfix(String infix) {
		char testCh;		
		StringBuilder postfix = new StringBuilder();
		LinkedStack S = new LinkedStack();
		for(int i=0; i<infix.length(); i++){
			testCh = infix.charAt(i);
			switch(testCh){
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix.append(testCh);
					break;
					
				case '+' :
				case '-' :
				case '*' :
				case '/' :
					postfix.append(' '); // 각 오퍼랜드의 값을 구분하기 위한 구분자로 사용
					S.push(testCh); 
					break;
					
				case ')' :
					postfix.append(' '); // 각 오퍼랜드의 값을 구분하기 위한 구분자로 사용
					postfix.append((char)S.pop()); 
					break;			
				
				default:
			}
		}
		return postfix.toString();
	}
	
	public int evalPostfix(String postfix){		
		LinkedStack S = new LinkedStack();
		StringBuilder val = new StringBuilder();
		exp = postfix;
		int opr1, opr2, value;			
	    char testCh;
	    
		for(int i=0; i<postfix.length(); i++){		
			testCh = exp.charAt(i);
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/'){
				if( testCh >= '0' && testCh <= '9' ) // testCh의 값이 정수 범위 일 때 48('0'), 57('9')
				{
					val.append(testCh);  // 수치문자를 val에 추가 저장 
					continue;      // 두자리 이상의 숫자 가능하도록 구현하기 위함 
				}
				if( val.length() != 0 )  // testCh값이 +-*/와 0~9가 아닌 경우(공백문자) 
				{
					value = Integer.parseInt(val.toString()); // 수치문자열을 숫자로 변환
					S.push(value); // 수치문자열을 숫자로 변환한 값 스택에 저장
					val.delete(0, val.length());  // val 문자열 객체를 초기화 시킴
				}
			}
			else{
				opr2 = S.pop();
				opr1 = S.pop();
				switch(testCh){
					case '+' : S.push(opr1 + opr2); break;
					case '-' : S.push(opr1 - opr2); break;
					case '*' : S.push(opr1 * opr2); break;
					case '/' : S.push(opr1 / opr2); break;
				}
			}			
		}
		return S.pop();		
	}	
}

public class Ex7_4_3 {
	static Scanner in = new Scanner(System.in);
	public static void main(String args[]){
		OptExp opt = new OptExp();
		String exp = null;
		String postfix =null;
		//(((100*2)+(100-99))-200), ((100*1)-90)
		System.out.print("수식 입력[ex:((3*5)-(6/2))] => ");
		exp = in.next();
		if(opt.testPair(exp))
			System.out.println("\n괄호 맞음!");
		else {
			System.out.println("괄호 틀림!!!");		
			return;
		}
						
		System.out.printf("\n후위표기식 : ");
		postfix = opt.infixTopostfix(exp);
		System.out.println(postfix);
		System.out.println("\n연산결과 = " + opt.evalPostfix(postfix));
	}
}