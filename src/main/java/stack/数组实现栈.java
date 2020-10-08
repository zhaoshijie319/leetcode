package stack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class 数组实现栈<T> implements Iterable<T>{

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    // 栈元素数组，只能通过转型来创建泛型数组
    private T[] a = (T[]) new Object[1];

    // 元素数量
    private int N = 0;

    public void push(T item) {
        check();
        a[N++] = item;
    }

    public T pop() throws Exception {

        if (isEmpty()) {
            throw new Exception("stack is empty");
        }

        T item = a[--N];

        check();

        // 避免对象游离
        a[N] = null;

        return item;
    }


    private void check() {

        if (N >= a.length) {
            resize(2 * a.length);

        } else if (N > 0 && N <= a.length / 4) {
            resize(a.length / 2);
        }
    }


    /**
     * 调整数组大小，使得栈具有伸缩性
     */
    private void resize(int size) {

        T[] tmp = (T[]) new Object[size];

        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }

        a = tmp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    @Override
    public Iterator<T> iterator() {

        // 返回逆序遍历的迭代器
        return new Iterator<T>() {

            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                return a[--i];
            }
        };

    }
}
