package JZ59;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;


public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        ArrayList<Integer> list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> sa = new Stack<>(), temp;
        TreeNode node;
        boolean flag = true;
        int len = 0;
        stack.push(pRoot);
        while (stack.size() != 0) {
            list = new ArrayList<>();
            len = stack.size();
            while (len-- > 0) {
                node = stack.pop();
                list.add(node.val);
                if (flag) {
                    if (node.left != null)
                        sa.push(node.left);
                    if (node.right != null)
                        sa.push(node.right);

                }
                else {
                    if (node.right != null)
                        sa.push(node.right);
                    if (node.left != null)
                        sa.push(node.left);

                }

            }
            flag = !flag;
            ans.add(list);
            temp = stack;
            stack = sa;
            sa = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(11);
        ArrayList<ArrayList<Integer>> ans = solution.Print(node);
    }
}
