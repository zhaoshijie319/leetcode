package collection;

public class Queue {

    protected static int len;
    protected static int head = 0;
    protected static int num = 0;
    protected static int[] array;

    public Queue(int len) {
        this.len = len;
        this.array = new int[len];
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);
        queue.offer(3);
//        queue.remove();
//        queue.remove();
        System.out.println(queue.peek());
        ;
        queue.offer(5);
        queue.offer(5);
        queue.remove();
        queue.offer(5);
        queue.offer(5);
        queue.offer(5);
    }

    public void offer(int i) throws Exception {
        if (num == len) {
            throw new Exception("队列满！");
        }
        array[head] = i;
        num++;
        if (head == len - 1) {
            head = 0;
            return;
        }
        head++;
    }

    public int peek() throws Exception {
        if (empty()) {
            throw new Exception("队列空！");
        }
        if (head == 0) {
            return array[len - 1];
        }
        return array[head - 1];
    }

    public int remove() throws Exception {
        if (empty()) {
            throw new Exception("队列空！");
        }
        int res = array[head];
        array[head] = 0;
        if (head == 0) {
            head = len - 1;
        }
        num--;
        return res;
    }

    public boolean empty() {
        return num == 0;
    }
}
