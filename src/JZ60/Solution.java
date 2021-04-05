package JZ60;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null)
            return ans;
        ArrayList<Integer> list;
        TreeNode node;
        int len;
        queue.add(pRoot);
        while (queue.size() != 0) {
            list = new ArrayList<>();
            len = queue.size();
            while (len-- > 0) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            ans.add(list);
        }

        return ans;
    }

}
