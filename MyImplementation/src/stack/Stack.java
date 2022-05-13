package stack;

import java.util.LinkedList;

public class Stack<E> {

	LinkedList<E> stack;

	Stack() {
		stack = new LinkedList<>();
	}

	public void push(E item) {
		if(item == null)
		{
			throw new NullPointerException();
		}
		stack.add(item);
	}

	public E pop() {
		E pop = stack.removeLast();
//		if (pop == null) {
//			throw new Exception("Stack Empty");
//		}
		return pop;
	}

	public E peek() {
		E peek = stack.getLast();
//		if (peek == null) {
//			throw new Exception("Stack Empty");
//		}
		return peek;
	}

	public boolean empty() {
		return stack.size() == 0;
	}

	public int search(Object o) {
		int search = stack.indexOf(o);
		return search != -1 ? search + 1 : -1;
	}

	@Override
	public String toString() {
		return  ""+ stack +"" ;
	}
	
}
