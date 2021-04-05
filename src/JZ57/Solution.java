package JZ57;

import util.TreeLinkNode;

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        TreeLinkNode node = null, pre = null;
        TreeLinkNode ans = null;
        //右结点为下一结点
        if (pNode.right != null) {
            node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            ans = node;
        }
        else {
            pre = pNode;
            node = pNode.next;
            while (node != null) {

                if (node.left == pre) {
                    //父节点为下一结点
                    ans = node;
                    break;
                }
                else {
                    pre = node;
                    node = node.next;
                }

            }
        }

        return ans;
    }
}
