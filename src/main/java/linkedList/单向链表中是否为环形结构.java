package linkedList;
/**
 * 题目:
 * 判断一个单向链表是否形成了环形结构.
 * <p>
 * 思路:
 * 定义两个指针,同时从链表头部出发,一个指针一次走一步,另一个指针一次走两步.如果走的快的指针追上了走的慢的指针,那么链表就是环形链表.
 * 如果走的快的的走到了链表尾部都没追上第一个指针,那么链表就不是环形链表.
 */
public class 单向链表中是否为环形结构 {
    
    static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        addTail(head, 2);
        addTail(head, 3);
        addTail(head, 4);
        addTail(head, 5);
        addTail(head, 6);
        addTail(head, 7);
        addTail(head, 8);
        ListNode _9 = addTail(head, 9);
        addTail(head, 10);
        addTail(head, 11);
        addTail(head, 12);
        addTail(head, 13);
        addTail(head, 14);
        ListNode tail = addTail(head, 15);
        tail.next = _9;

        System.out.println(hasCycle(head));
    }

    private static ListNode addTail(ListNode head, int value) {
        ListNode node = new ListNode(value);
        if (head != null) {
            ListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
        return node;
    }
}