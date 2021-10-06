import java.util.*;

class StackLL{
	
	private LinkedList<Integer> stack;

	StackLL(){
		stack = new LinkedList<>();
	}

	int pop(){
		if(stack.size() == 0){
			System.out.println("ERROR: Popping from empty Stack...");
			return Integer.MIN_VALUE;
		}
		int poppedItem = stack.getFirst();
		stack.removeFirst();
		return poppedItem;
	}

	int top(){
		if(stack.size() == 0){
			System.out.println("ERROR: Popping from empty Stack...");
			return Integer.MIN_VALUE;
		}
		return stack.getFirst();	
	}

	void push(int item){
		stack.addFirst(item);
	}

	int size(){
		return stack.size();
	}

	boolean isEmpty(){
		return stack.size() == 0;
	}
}

public class StackUsingLinkedList{
	public static void main(String[] args) {
		StackLL stack = new StackLL();
		stack.push(12);
		System.out.println(stack.top());
		stack.push(24);
		stack.push(36);
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(99);
		stack.push(108);
		System.out.println(stack.pop());
	}
}