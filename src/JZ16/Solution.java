package JZ16;

import util.ListNode;

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode l = list1, r = list2;
        ListNode p = null;
        ListNode head = list1.val <= list2.val ? list1 : list2;
        while (l != null && r != null) {
            if (l.val > r.val) {
                if (p != null) {
                    p.next = r;

                }
                p = r;
                r = r.next;

            }
            else {
                if (p != null) {
                    p.next = l;
                }
                p = l;
                l = l.next;

            }
        }

        if (l == null)
            p.next = r;
        if (r == null)
            p.next = l;


        return head;
    }
}
