package JZ58;

import util.TreeNode;

import java.util.Stack;


public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        if ((pRoot.left == null) || (pRoot.right == null)) {
            return (pRoot.left == null) == (pRoot.right == null);
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node1, node2;
        stack1.push(pRoot.left);
        stack2.push(pRoot.right);
        while (stack1.size() != 0 && stack2.size() != 0) {
            node1 = stack1.pop();
            node2 = stack2.pop();
            //先根遍历和反先根遍历
            while (node1 != null && node2 != null) {
                if (node1.val != node2.val)
                    return false;
                stack1.push(node1.right);
                stack2.push(node2.left);
                node1 = node1.left;
                node2 = node2.right;
            }
            if ((node1 == null) ^ (node2 == null)) {
                return false;
            }

        }

        return (stack1.size() == 0)&& (stack2.size() == 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(8);

        boolean ans = solution.isSymmetrical(node);
    }
}
