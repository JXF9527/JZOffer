package JZ26;

import util.TreeNode;

public class Solution {
    //二叉搜索树中序遍历为排序序列

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        dfs(pRootOfTree);
        return head;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (pre != null)
            pre.right = node;
        else
            head = node;
        node.left = pre;
        pre = node;
        dfs(node.right);
    }
}
