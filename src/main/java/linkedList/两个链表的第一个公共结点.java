package linkedList;

import java.util.Stack;

/**
 * 题目:
 * 输入两个链表,找出他们的第一个公共结点.
 */
public class 两个链表的第一个公共结点 {

    /**
     * 思路1:栈
     * 遍历两个链表,压入两个栈,然后再依次出栈元素,判断是否相同,相同继续出栈,不相同,则前一个就是第一个公共结点.
     * <p>
     * 思路2:差值
     * 先获取两个链表的长度,计算链表长度的差值,然后较长的先走差值,再两个链表同时遍历,碰到一个相同的元素就是第一个公共结点.
     * <p>
     * 思路3:双指针
     * 两个指针分别遍历两个链表，到头交换遍历，节点相同后返回
     */

    public ListNode FindFirstCommonNode_1(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> pStack1 = new Stack<ListNode>();
        Stack<ListNode> pStack2 = new Stack<ListNode>();
        while (pHead1 != null) {
            pStack1.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            pStack2.add(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode temp = null;
        while (!pStack1.isEmpty() && !pStack2.isEmpty()) {
            ListNode pH1 = pStack1.pop();
            ListNode pH2 = pStack2.pop();
            if (pH1.val == pH2.val) {
                temp = pH1;
            } else {
                break;
            }
        }
        return temp;

    }

    public ListNode FindFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while (temp1 != temp2) {
            temp1 = (temp1 == null ? pHead2 : temp1.next);

            temp2 = (temp2 == null ? pHead1 : temp2.next);
            System.out.println(pHead1.val);
        }

        return temp1;
    }
}
