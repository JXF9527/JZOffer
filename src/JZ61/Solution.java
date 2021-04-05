package JZ61;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    String Serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer buffer = new StringBuffer();
        StringBuffer ebuf = new StringBuffer();
        TreeNode node;
        int len;
        queue.add(root);
        while (queue.size() != 0) {
            len = queue.size();
            while (len-- > 0) {
                node = queue.poll();
                if (node == null) {
                    ebuf.append("#,");
                }
                else {
                    buffer.append(ebuf);
                    ebuf.delete(0, ebuf.length());
                    buffer.append(node.val);
                    buffer.append(',');

                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }
    TreeNode Deserialize(String str) {
        if (str.length() == 0)
            return null;
        String[] sa = str.split(",");
        if (sa.length == 0)
            return null;
        TreeNode head = new TreeNode(Integer.valueOf(sa[0]));
        TreeNode node = head;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int count = 0, j = 1, i;
        int k = 2;    //控制当前结点的左右子树
        while (queue.size() != 0 && j < sa.length) {
            count = queue.size();
            for (i = 0; (i < 2 * count) && (j + i < sa.length); i++) {
                if (sa[j + i].equals("#")) {
                    if (k == 2) {
                        --k;
                    }
                    else {
                        queue.poll();
                        k = 2;
                    }
                }
                else {
                    node = new TreeNode(Integer.valueOf(sa[j + i]));
                    if (k == 2) {
                        queue.peek().left = node;
                        --k;
                    }
                    else {
                        queue.peek().right = node;
                        queue.poll();
                        k = 2;
                    }
                    queue.add(node);

                }
            }
            j += 2 * count;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        //node.right = new TreeNode(10);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(2);
        //node.left.right = new TreeNode(7);
        //node.right.left = new TreeNode(9);
        //node.right.right = new TreeNode(11);
        String ans = solution.Serialize(node);
        TreeNode head = solution.Deserialize(ans);
    }
}
