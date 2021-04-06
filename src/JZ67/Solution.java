package JZ67;

public class Solution {
    public int cutRope(int target) {
        if (target <= 2)
            return 1;
        int max = 0, mod = target % 3;
        int sum = target / 3;
        switch (mod) {
            case 0:
                max = (int)Math.pow(3, sum);
                break;
            case 1:
                max = (int)Math.pow(3, sum - 1) * 4;
                break;
            case 2:
                max = (int)Math.pow(3, sum) * 2;
                break;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.cutRope(8);
    }
}
