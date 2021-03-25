package JZ36;

import util.ListNode;

public class Solution {
    //链表长度len1与len2,长的先移动|len1 - len2|，然后一起移动，比较是否为相同节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode node1 = pHead1, node2 = pHead2;
        int sub = 0;
        ListNode ans = null;
        for (;node1 != null; node1 = node1.next)
            ++len1;

        for (;node2 != null; node2 = node2.next)
            ++len2;

        node1 = pHead1;
        node2 = pHead2;

        if (len1 > len2) {
            sub = len1 - len2;
            for (;sub > 0; node1 = node1.next)
                --sub;

        }
        else {
            sub = len2 - len1;
            for (;sub > 0; node2 = node2.next)
                --sub;
        }

        while (node1 != null && node2 != null) {
            if (node1 == node2) {
                ans = node1;
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return ans;
    }
}
