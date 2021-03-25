package JZ38;

import util.TreeNode;

public class Solution {
    private int deepth = 0;
    private int max = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        ++deepth;
        max = max > deepth ? max : deepth;
        TreeDepth(root.left);
        TreeDepth(root.right);
        --deepth;
        return max;
    }
}
