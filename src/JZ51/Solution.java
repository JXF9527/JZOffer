package JZ51;

import java.util.Arrays;

public class Solution {
    //从前往后计算一部分，从后往前计算剩下的
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int i, sum = 1;
        B[0] = 1;
        for (i = 1; i < B.length; i++) {
            sum *= A[i - 1];
            B[i] += sum;
        }
        sum = 1;
        for (i = B.length - 2; i >= 0; --i) {
            sum *= A[i + 1];
            B[i] *= sum;
        }
        return B;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.multiply(new int[]{1,2,3,4,5});
    }
}