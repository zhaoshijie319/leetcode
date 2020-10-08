package collection;

import lombok.Data;

public class NodeStack {

    @Data
    static class Node {

        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    static class MyStack {

        Node top;

        void push(Node n) {
            if (n != null) {
                n.next = top;
                top = n;
            }
        }

        Node pop() {
            if (top == null) {
                return top;
            } else {
                Node t = new Node(top.val);
                top = top.next;
                return t;
            }

        }
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(new Node(1));
        myStack.push(new Node(2));
//        myStack.push(new Node(3));

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

}
