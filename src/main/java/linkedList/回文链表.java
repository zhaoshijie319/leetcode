package linkedList;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * <p>Follow up: Could you do it in O(n) time and O(1) space?
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;

        stack.push(head.val);

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }

        while (slow.next != null) {
            slow = slow.next;
            Integer tmp = stack.pop();
            if (tmp != slow.val) {
                return false;
            }
        }

        return true;
    }
}
