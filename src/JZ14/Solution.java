package JZ14;
import util.ListNode;

import java.util.*;



public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */

    static public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode node = pHead;
        ListNode ans = null;
        int count = 0;
        int i = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        node = pHead;
        if (count - k >= 0) {
            while (node != null) {
                if (i == count - k) {
                    ans = node;
                    break;
                } else {
                    ++i;
                    node = node.next;
                }
            }
        }
        return ans;
    }

    //可用双指针

    static public void main(String[] args) {

    }
}


