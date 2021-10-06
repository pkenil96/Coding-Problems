import java.util.*;

class StackDA{
	
	private ArrayList<Integer> stack;

	StackDA(){
		stack = new ArrayList<>();
	}

	int pop(){
		if(stack.size() == 0){
			System.out.println("ERROR: Popping from empty Stack...");
			return Integer.MIN_VALUE;
		}
		int lastElementIndex = stack.size()-1;
		int poppedItem = stack.get(lastElementIndex);
		stack.remove(lastElementIndex);
		return poppedItem;
	}

	int top(){
		if(stack.size() == 0){
			System.out.println("ERROR: Popping from empty Stack...");
			return Integer.MIN_VALUE;
		}
		int lastElementIndex = stack.size()-1;
		int topItem = stack.get(lastElementIndex);
		return topItem;	
	}

	void push(int item){
		stack.add(item);
	}

	int size(){
		return stack.size();
	}

	boolean isEmpty(){
		return stack.size() == 0;
	}
}

public class StackUsingDynamicArray{
	public static void main(String[] args) {
		StackDA stack = new StackDA();
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