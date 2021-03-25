package JZ31;

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = i; j != 0; j /= 10) {
                if (j % 10 == 1)
                    ++sum;
            }
        }
        return sum;
    }

    static public void main(String[] args) {
        Solution s = new Solution();
        int ans = s.NumberOf1Between1AndN_Solution(13);
    }
}
