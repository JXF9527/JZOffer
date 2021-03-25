package JZ39;

import util.TreeNode;

public class Solution {
    private boolean ans = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        Deep(root);
        return ans;
    }

    private int Deep(TreeNode node) {
        if ((node == null) || !ans)
            return 0;
        int left = Deep(node.left) + 1;
        int right = Deep(node.right) + 1;
        if (Math.abs(left - right) > 1)
            ans = false;
        return Math.max(left, right);
    }

    static public void main(String[] args) {
        Solution solution = new Solution();
        int i = 5;
        TreeNode head = null, node, pre = null;
        node = new TreeNode(1);
        pre = node;
        node = new TreeNode(2);
        pre.left = node;
        head = node;
        node = new TreeNode(3);
        pre.right = node;
        pre = head;
        node = new TreeNode(4);
        pre.left = node;
        node = new TreeNode(5);
        pre.right = node;
        pre = node;
        node.left = new TreeNode(6);
        /*
        while (i-- > 0) {
            node = new TreeNode(5 -i);
            if (pre == null)
                head = node;
            else
                pre.left = node;
            pre = node;
        }
         */

        boolean ans = solution.IsBalanced_Solution(head);

    }

}
