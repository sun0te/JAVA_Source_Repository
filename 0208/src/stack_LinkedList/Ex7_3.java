package stack_LinkedList;

import java.util.Scanner;

// [실습] 괄호가 있는 수식을 입력받아 괄호 짝이 맞는지 검사한 다음 
// 짝이 맞으면 중위식을 후위식으로 변환한 다음
// 스택을 이용해서 연산한 결과를 출력하는 프로그램을 작성하시오.

/*
 * OptExp 클래스의 메서드는 다음과 같다
1. TestPair() : 괄호 짝이 맞는지 검사 (스택)
2. infix_to_postfix() : 중위식을 후위식으로 변환 (스택)
3. evalPostfix() : 후위식을 이용해서 연산결과 출력 (스택) 
 */

interface Stack {
	//char -> int
	boolean isEmpty();
	void push(int item); 
	int pop();
	void delete();
	int peek();
}

class StackNode {
	int data;	//char -> int
	StackNode link;
}

class LinkedStack implements Stack{
	private StackNode top; //스텍 포인터
	
	public LinkedStack() {
	}
	
	//오버라이딩
	public boolean isEmpty(){ //빈 스텍인지 check
		return (top == null);
	}
	
	public void push(int item){	//데이터 삽입
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
//		System.out.println("Insert Item : " + item);
	}
	
	//char -> int
	public int pop(){	//데이터 삭제(데이터 반환 후)
		if(isEmpty()) {
			System.out.println("데이터가 비어있습니다.");
			return 0;
		}
		else {
			int item = top.data;
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
	
	public int peek(){	//스텍 포인터(top) 위치 데이터 값만 반환
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
						openPair = (char) S.pop();
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
	
public String infix_to_postfix(String infix) {
		/*
		 	① 왼쪽 괄호를 만나면 무시하고 다음 문자를 읽는다.
			② 피연산자를 만나면 출력한다.
			③ 연산자를 만나면 스택에 push한다.
			④ 오른쪽괄호를 만나면 스택을 pop하여 출력한다.
			⑤ 수식이 끝나면, 스택이 공백이 될 때까지 pop하여 출력한다.
		*/
		char testCh;		
		StringBuilder postfix = new StringBuilder();
		LinkedStack S = new LinkedStack();
		
		for(int i = 0; i < infix.length(); i++) {
			testCh = this.exp.charAt(i);
			switch(testCh) {
				case '0' :
				case '1' :
				case '2' :
				case '3' :
				case '4' :
				case '5' :
				case '6' :
				case '7' :
				case '8' :
				case '9' :
					postfix.append(testCh);	//문자열에 추가
					break;
				
				case '+':
				case '-':
				case '*':
				case '/':
					postfix.append(' ');	//각 오퍼랜드 값을 구분하기 위한 구분자로 사용
					S.push(testCh);
					break;
				
				case ')' :
				case '}' :
				case ']' :
					postfix.append(' ');	//각 오퍼랜드 값을 구분하기 위한 구분자로 사용
					postfix.append((char)S.pop());
					break;
					
				default:
			}//switch
		}//for
		return postfix.toString();
	}
	
	public int evalPostfix(String postfix) {
		/*
		 	① 피연산자를 만나면 스택에 push 한다.
			② 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop하여 연산하고, 연산결과를 다시 스택에 push 한다.
			③ 수식이 끝나면, 마지막으로 스택을 pop하여 출력한다.
		 */
		
		LinkedStack S = new LinkedStack();
		StringBuilder val = new StringBuilder();
		exp = postfix;
		int opr1, opr2, value;
		char testCh;
		
		for(int i = 0; i < postfix.length(); i++) {
			testCh = exp.charAt(i);
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/') {
				if(testCh >= '0' && testCh <= '9') 	//testCh 의 값이 정부 범위일 때 48(0), 57(9)
				{	
					val.append(testCh);	//수치문자를 val에 추가 저장
					continue;	//두 자리 이상의 숫자 가능하도록 구현하기 위함, for문으로 다시 
				}
				if(val.length() != 0)	//testCh값이 =-+/와 0~9가 아닌 경우(공백문자)
				{
					value = Integer.parseInt(val.toString());	//수치 문자열을 숫자로 변환
					S.push(value);	//수치 문자열을 숫자로 변환하는 값 스택에 저장
					val.delete(0, val.length());	// val 문자열 객체를 초기화 시킴
				}
			}//if
			else  {
				opr2 = S.pop();
				opr1 = S.pop();
				switch(testCh) {
					case '+' : S.push(opr1 + opr2); break;
					case '-' : S.push(opr1 - opr2); break;
					case '*' : S.push(opr1 * opr2); break;
					case '/' : S.push(opr1 / opr2); break;
				}
			}//else
		}//for
		return S.pop();
		
	}
	
}

public class Ex7_3 {
	static Scanner in = new Scanner(System.in);
	public static void main(String args[]){
		OptExp opt = new OptExp();
		String exp = null;
		String postfix = null;
		
		//(((100*2)+(100-99))-200), ((100*1)-90)
		System.out.print("수식 입력[ex:((3*5)-(6/2))] => ");
		exp = in.next();
		if(opt.testPair(exp))
			System.out.println("\n괄호 맞음!");
		else {
			System.out.println("괄호 틀림!!!");		
			return;
		}
		
		System.out.printf("\n후위 표기식 : ");
		postfix = opt.infix_to_postfix(exp);
		System.out.println(postfix);
		System.out.print("연산 결과 : " + opt.evalPostfix(postfix));
	}

}
