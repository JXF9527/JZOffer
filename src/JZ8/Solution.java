package JZ8;

public class Solution {
    public int JumpFloor(int target) {
        if (target == 0)
            return 0;
        else if (target == 1)
            return 1;

        int ans = 0;
        int a = 1, b = 1;
        for (int i = 2; i <= target; ++i) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }
}