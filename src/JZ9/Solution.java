package JZ9;

public class Solution {
    static public int JumpFloorII(int target) {
        if (target == 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        // 1 2 3 4 5
        // 1 2 4
        //1+1+1 1+2 2+1 3
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= target; ++i) {
            dp[i] = 1;
            for (int j = 1; j < i; ++j) {
                dp[i] += dp[j];
            }

        }

        return dp[target];
    }

    static public void main(String[] args) {
        JumpFloorII(3);
    }
}
