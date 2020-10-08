package collection;

import lombok.Data;

public class NodeQueue {

    @Data
    static class Node {

        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    static class Queue {

        Node first, last;

        void offer(Node n) {
            if (first == null) {
                first = n;
                last = first;
            } else {
                last.next = n;
                last = n;
            }
        }

        Node poll() {
            if (first == null) {
                return null;
            }
            Node t = new Node(first.val);
            first = first.next;
            return t;
        }
    }


    public static void main(String[] args) {
        Queue q = new Queue();
        q.offer(new Node(1));
        q.offer(new Node(3));
//        q.offer(new Node(5));
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

}
