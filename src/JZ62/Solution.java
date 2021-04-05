package JZ62;

import util.TreeNode;

public class Solution {
    private int count = 0;
    private TreeNode ans = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        count = k;
        help(pRoot);
        return ans;
    }

    private void help(TreeNode node) {
        if (node == null || ans != null)
            return;
        help(node.left);
        count--;
        if (count == 0)
            ans = node;
        help(node.right);
    }

}
