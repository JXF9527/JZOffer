package JZ56;

import util.ListNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;
        ListNode node = pHead;
        ListNode cnode;
        ListNode ans = null, anode = null;

        while (node != null && node.next != null) {
            cnode = node;

            while (cnode.next != null && cnode.next.val == cnode.val) {
                cnode = cnode.next;
            }

            if (node == cnode) {
                if (ans == null) {
                    ans = cnode;
                    anode = cnode;
                }
                else
                    anode.next = cnode;
                anode = cnode;
                node = node.next;
            }
            else
                node = cnode.next;
        }


        if (ans == null)
            ans = node;
        else
            anode.next = node;



        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode ans = solution.deleteDuplication(head);
    }
}
