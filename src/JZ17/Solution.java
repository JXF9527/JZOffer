package JZ17;

import util.TreeNode;

import java.util.*;

public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean ans = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                ans = dfs(root1, root2);
            }

            if (!ans)
                ans = HasSubtree(root1.left, root2);
            if (!ans)
                ans = HasSubtree(root1.right, root2);

        }



        return ans;
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return dfs(root1.left, root2.left) && dfs(root1.right, root2.right);

    }

    //层次遍历
    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> list = new LinkedList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        TreeNode l = null, r = null;
        TreeNode node = null;
        int num = 0;
        list.add(root1);
        while (list.isEmpty()) {
            num = list.size();
            while (num-- > 0) {
                node = list.poll();
                if (node != null) {
                    l1.add(node.val);
                    list.add(node.left);
                    list.add(node.right);
                }
                else {
                    l1.add(Integer.MIN_VALUE);
                }
            }

        }

        list.add(root2);
        while (list.isEmpty()) {
            num = list.size();
            while (num-- > 0) {
                node = list.poll();
                if (node != null) {
                    l2.add(node.val);
                    list.add(node.left);
                    list.add(node.right);
                }
                else {
                    l2.add(Integer.MIN_VALUE);
                }
            }

        }

        int i = 0, j = 0;
        while (i < l1.size()) {
            if (l1.get(i) == l2.get(j)) {
                ++i;
                ++j;
                if (j == l2.size())
                    return true;
            }
            else {
                j = 0;
                ++i;
            }
        }

        return false;
    }

    static public boolean test(List<Integer> l1, List<Integer> l2) {
        int i = 0, j = 0;
        while (i < l1.size()) {
            if (l1.get(i) == l2.get(j)) {
                ++i;
                ++j;
                if (j == l2.size())
                    return true;
            }
            else {
                j = 0;
                ++i;
            }
        }

        return false;
    }


    static public void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(1);list.add(2);
        list.add(3);
        list2.add(2);list2.add(3);
        boolean t = test(list, list2);
    }
}
