package JZ55;

import util.ListNode;

public class Solution {

    /**
     * 设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点。
     * 接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return null;
        ListNode node1 = pHead.next, node2 = pHead.next.next;
        while (node1 != null && node2 != null && node2.next != null) {
            if (node1 == node2) {

                node1 = pHead;
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;

            }
            node1 = node1.next;
            node2 = node2.next.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next.next;
        ListNode ans = solution.EntryNodeOfLoop(head);
    }
}
