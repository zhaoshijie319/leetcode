package linkedList;

import java.util.LinkedList;

public class 从尾到头打印链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        addTail(head, 2);
        addTail(head, 3);
        addTail(head, 4);
        addTail(head, 5);

        method1(head);
        System.out.println();
        method2(head);
    }

    private static void method1(ListNode head) {
        LinkedList<Integer> nodes = new LinkedList<>();

        while (head != null) {
            nodes.push(head.val);
            head = head.next;
        }

        while (!nodes.isEmpty()) {
            System.out.print(nodes.pop() + " ");
        }
    }

    private static void method2(ListNode head) {
        if (head != null) {
            method2(head.next);
            System.out.printf(head.val + " ");
        }
    }


    private static void addTail(ListNode head, int value) {
        ListNode node = new ListNode(value);
        if (head != null) {
            ListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
}
