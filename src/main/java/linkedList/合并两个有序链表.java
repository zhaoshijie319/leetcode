package linkedList;

public class 合并两个有序链表 {

    public static void main(String[] args) throws Exception {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(8);

        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(7);
        ListNode head6 = new ListNode(10);

        head.next = head1;
        head1.next = head2;

        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        ListNode newHead = new 合并两个有序链表().mergeTwoLists(head, head3);
        ListNode link = newHead;
        while (link != null) {
            System.out.println(link.val);
            link = link.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);

        ListNode curNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
