package testPair;

import java.util.Scanner;

// [실습] 연결 자료구조 방식을 이용하여 구현한 스택 프로그램 (수식괄호검사)
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
//		System.out.println("Insert Item : " + item);
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

class OptExp {
	private String exp;
	private int expSize;
	private char testCh, openPair;
	
	public boolean testPair(String exp) {
		/*
		LinkedStack newStack = new LinkedStack();
		int expSize = exp.length();
		
		for (int i = 0; i < expSize; i++) {
		    char ch = exp.charAt(i);
		    
		    if (ch == '(' || ch == '{' || ch == '[') {
		      newStack.push(ch);
		    } else if (ch == ')' || ch == '}' || ch == ']') {
		      if (newStack.isEmpty()) {
		        return false;
		      } else {
		        newStack.pop();
		      }
		    }
		}//for
		  
		  if (newStack.isEmpty()) {
		    return true;
		  } 
		  else {
		    return false;
		  }
		 */
		
		this.exp = exp;
		LinkedStack S = new LinkedStack();
		expSize = this.exp.length();
		for(int i = 0; i < expSize; i++) {
			testCh = this.exp.charAt(i);
			switch(testCh) {
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
					else {
						openPair = S.pop();
						if ((openPair == '(' && testCh != ')') || //짝이 맞는지 확인
							(openPair == '{' && testCh != '}') ||	
							(openPair == '[' && testCh != ']'))
							return false;
						else
							break; //switch 빠져나와서 for문으로 다시
					}
			}//switch
		}//for
		if(S.isEmpty())
			return true;
		else
			return false;
	}
}

public class Ex7_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OptExp opt = new OptExp();
		
//		System.out.print("괄호가 포함된 수식을 입력하세요 => ");
//		String exp = sc.nextLine();
		
		String exp = "((3*5)-(6-2))";
		System.out.println(exp);
		
		if(opt.testPair(exp))
			System.out.println("괄호 맞음");
		else 
			System.out.println("괄호 틀림!!");
		
	}

}
