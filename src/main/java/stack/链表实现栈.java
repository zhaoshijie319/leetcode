package stack;

import java.util.Iterator;

public class 链表实现栈<T> implements Iterable<T> {
    private Node top = null;
    private int N = 0;


    private class Node {
        T item;
        Node next;
    }

    public void push(T item) {

        Node newTop = new Node();

        newTop.item = item;
        newTop.next = top;

        top = newTop;

        N++;
    }

    public T pop() throws Exception {

        if (isEmpty()) {
            throw new Exception("stack is empty");
        }

        T item = top.item;

        top = top.next;
        N--;

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private Node cur = top;


            @Override
            public boolean hasNext() {
                return cur != null;
            }


            @Override
            public T next() {
                T item = cur.item;
                cur = cur.next;
                return item;
            }
        };

    }
}
