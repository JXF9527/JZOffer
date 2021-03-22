package JZ21;



class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode front = null;
    public ListNode(int val) {
        this.val = val;
    }
}


public class Solution {
    //双向链表搜索
    static public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0) {
            return (popA.length == 0);
        }
        if (pushA.length != popA.length)
            return false;
        ListNode p = null, node = null;
        ListNode head = null;
        int i;
        boolean ans = false;


        for (i = 0; i < pushA.length; i++) {
            node = new ListNode(pushA[i]);
            if (p != null) {
                p.next = node;
                node.front = p;
            }
            else
                head = node;
            p = node;
        }

        node = head;
        i = 0;
        while (node != null) {
            if (node.val == popA[i]) {
                //找到匹配的出栈，然后在相邻节点找下一个匹配的
                ++i;
                if (i == popA.length) {
                    ans = true;
                    break;
                }

                if (node.front != null)
                    node.front.next = node.next;
                if (node.next != null)
                    node.next.front = node.front;

                if (node.front != null)
                    node = node.front;
                else
                    node = node.next;

            }
            else {
                node = node.next;
            }
        }

        return ans;
    }

    static public void main(String[] args) {
        boolean ans = IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
    }

}
