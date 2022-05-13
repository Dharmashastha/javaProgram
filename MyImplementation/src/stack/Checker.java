package stack;

public class Checker {

	public static void main(String[] args) {
		
		Stack<Integer> stackCall = new Stack<>();
		
		
		stackCall.push(1);
		stackCall.push(2);
		stackCall.push(10);
		stackCall.push(64);
		stackCall.push(100);
		
		System.out.println(Math.pow(0, 0));
//		System.out.println(stackCall.pop());
//		System.out.println(stackCall.pop());
//		System.out.println(stackCall.pop());
		
		System.out.println(stackCall);
		System.out.println(stackCall.empty());
		
		System.out.println(stackCall.peek());
		
		System.out.println(stackCall.peek());
		
		System.out.println(stackCall.search(10));
		
		System.out.println(stackCall.search(11));
	}

}
