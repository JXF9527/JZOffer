package JZ15;

import util.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (head != null) {
            node = head;
            head = head.next;
            node.next = pre;
            pre = node;
        }

        return node;
    }
}
