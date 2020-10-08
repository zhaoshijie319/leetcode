package collection;

public class Stack {
    protected static int len;
    protected static int index = 0;
    protected static int[] array;

    public Stack(int len) {
        this.len = len;
        this.array = new int[len];
    }

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        stack.push(5);
        stack.pop();
//        stack.pop();
//        stack.peek();
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
//        stack.push(3);
    }

    public void push(int i) throws Exception {
        if (index >= len) {
            throw new Exception("栈满！");
        }
        array[index++] = i;
    }

    public int peek() throws Exception {
        if (empty()) {
            throw new Exception("栈空！");
        }
        return array[index - 1];
    }

    public int pop() throws Exception {
        if (empty()) {
            throw new Exception("栈空！");
        }
        int res = array[index];
        array[index--] = 0;
        return res;
    }

    public boolean empty() {
        return index == 0;
    }
}
