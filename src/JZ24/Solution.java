package JZ24;

import util.TreeNode;

import java.util.ArrayList;


public class Solution {
    private ArrayList<Integer> cway = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return ans;
        dfs(root, target);
        return ans;
    }

    public void dfs(TreeNode node, int value) {
        if (node == null)
            return;
        cway.add(node.val);
        if (value == node.val) {
            if (node.left == null && node.right == null)
                ans.add((ArrayList<Integer>)cway.clone());
        }
        else {
            dfs(node.left, value - node.val);
            dfs(node.right, value - node.val);
        }
        cway.remove(cway.size() - 1);
    }

}
