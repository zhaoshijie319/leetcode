package linkedList;

public class 删除链表节点 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        new 删除链表节点().deleteNode(node.next.next.next);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void deleteNode(ListNode node) {

        if (node == null || node.next == null) {
            return;
        }
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
    }
}
