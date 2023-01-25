package stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
		// Stack - LIFO
		Stack<String> stack = new Stack<>();
		stack.push("��1");
		stack.push("��2");
		stack.push("��3");
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		// Queue - FIFO
		Queue<String> q = new LinkedList<>();
		q.offer("ť��1");
		q.offer("ť��2");
		q.offer("ť��3");
		
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
