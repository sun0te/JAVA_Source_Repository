import java.util.LinkedList;

public class StackExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> stack = new LinkedList<Integer>(); 
		stack.addLast(12); 
		stack.addLast(59); 
		stack.addLast(7); 
		System.out.println("stack.getLast() : " + stack.getLast());
		while(!stack.isEmpty()) {
			Integer num = stack.removeLast(); 
			System.out.println(num);
		}

	}

}
