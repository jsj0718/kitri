package stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
		// Stack - LIFO
		Stack<String> stack = new Stack<>();
		stack.push("값1");
		stack.push("값2");
		stack.push("값3");
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		// Queue - FIFO
		Queue<String> q = new LinkedList<>();
		q.offer("큐값1");
		q.offer("큐값2");
		q.offer("큐값3");
		
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
