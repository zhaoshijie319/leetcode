package queue;

import java.util.Stack;

public class 用两个栈实现队列 {

    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public 用两个栈实现队列() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Stack<Integer> auxStack = new Stack<>();
        while (!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
        int result = auxStack.pop();
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        Stack<Integer> auxStack = new Stack<>();
        while (!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
        int result = auxStack.peek();
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
