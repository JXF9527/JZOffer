package JZ19;

import java.util.ArrayList;

public class Solution {
    static private ArrayList<Integer> ans = new ArrayList<>();
    static public ArrayList<Integer> printMatrix(int [][] matrix) {

        if (matrix.length == 0)
            return ans;
        int n = matrix[0].length - 1, m = matrix.length - 1;
        int count = (m + 1) * (n + 1);
        int deep = 0;
        int i, j;

        while (ans.size() < count) {
            help(matrix, m, n, deep);
            --m;
            --n;
            ++deep;
        }


        return ans;

    }

    //横：deep~n，纵：deep~m
    static public void help(int[][] matrix, int m, int n, int deep) {
        int i, j;
        if (m == deep) {
            for (j = deep; j <= n; j++) {
                ans.add(matrix[deep][j]);
            }
        }
        else if (n == deep) {
            for (i = deep; i <= m; i++) {
                ans.add(matrix[i][deep]);
            }
        }
        else {
            for (j = deep; j < n; j++) {
                ans.add(matrix[deep][j]);
            }

            for (i = deep; i < m; i++) {
                ans.add(matrix[i][n]);
            }

            for (j = n; j > deep; j--) {
                ans.add(matrix[m][j]);
            }

            for (i = m; i > deep; i--) {
                ans.add(matrix[i][deep]);
            }
        }
    }


    static public void main(String[] args) {
        ArrayList<Integer> it = printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }

}
