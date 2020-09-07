package JZ4;

import util.TreeNode;

import java.util.Arrays;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static public TreeNode reConstructBinaryTree2(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        return dfs(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    static private TreeNode dfs(int[] pre, int prestart, int preend, int[] in, int instart, int inend) {
        if (instart == inend)
            return new TreeNode(in[instart]);

        if (prestart == preend) {
            return new TreeNode(pre[prestart]);
        }

        if (prestart > preend) {
            return null;
        }


        TreeNode root = new TreeNode(pre[prestart]);

        int index = instart;

        for (int i = instart; i <= inend; ++i) {
            if (pre[prestart] == in[i]) {
                index = i;
                break;
            }
        }

        root.left = dfs(pre, prestart + 1, index, in, instart, index - 1);

        root.right = dfs(pre, index + 1, preend, in, index + 1, inend);

        return root;

    }

    static public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //数组长度为0的时候要处理
        if(pre.length == 0){
            return null;
        }

        int rootVal = pre[0];

        //数组长度仅为1的时候就要处理
        if(pre.length == 1){
            return new TreeNode(rootVal);
        }

        //我们先找到root所在的位置，确定好前序和中序中左子树和右子树序列的范围
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for(int i = 0;i < in.length; i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }

        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }

    static public void main(String[] args) {
        TreeNode node = reConstructBinaryTree(new int[]{1,2,3,4,5,6,7}, new int[]{3,2,4,1,6,5,7});
    }
}