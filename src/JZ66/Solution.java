package JZ66;

public class Solution {
    private int threshold;
    private int ans = 0;
    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0)
            return 0;
        this.threshold = threshold;
        dfs(new boolean[rows][cols], 0, 0);
        return ans;
    }

    private void dfs(boolean[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length)
            return;
        if (j < 0 || j >= matrix[0].length)
            return;
        if (matrix[i][j])
            return;
        if (cul(i, j) > threshold)
            return;
        matrix[i][j] = true;
        ++ans;
        dfs(matrix, i + 1, j);
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j + 1);
        dfs(matrix, i, j - 1);
    }

    private int cul(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += (i % 10);
            i /= 10;
        }

        while (j != 0) {
            sum += (j % 10);
            j /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.movingCount(5, 10, 10);
    }

}
