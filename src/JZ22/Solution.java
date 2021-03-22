package JZ22;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> nodelist = new LinkedList<>();
        TreeNode node = null;
        int len = 0;
        nodelist.add(root);
        while (nodelist.size() != 0) {
            len = nodelist.size();
            while (len-- > 0) {
                node = nodelist.poll();
                ans.add(node.val);
                if (node.left != null)
                    nodelist.add(node.left);
                if (node.right != null)
                    nodelist.add(node.right);
            }

        }

        return ans;
    }
}
