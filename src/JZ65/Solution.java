package JZ65;

import java.util.*;


public class Solution {
    private char[] ac;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        if (matrix.length == 0 || word.length() == 0)
            return false;
        ac = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == ac[0]) {
                    if (help(matrix, 0, i, j, new boolean[matrix.length][matrix[0].length]))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean help(char[][] matrix, int cur, int i, int j, boolean[][] mark) {
        if (cur == ac.length)
            return true;

        if (i < 0 || i >= matrix.length)
            return false;
        if (j < 0 || j >= matrix[0].length)
            return false;
        if (mark[i][j])
            return false;

        if (matrix[i][j] == ac[cur]) {
            mark[i][j] = true;
            if (help(matrix, cur + 1, i - 1, j, mark))
                return true;
            if (help(matrix, cur + 1, i + 1, j, mark))
                return true;
            if (help(matrix, cur + 1, i, j - 1, mark))
                return true;
            if (help(matrix, cur + 1, i, j + 1, mark))
                return true;
            mark[i][j] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] m = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        boolean ans = solution.hasPath(m, "abcb");
    }
}
