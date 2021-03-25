package JZ30;

public class Solution {
    //O(n)
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            max = max > sum ? max : sum;
            sum = sum < 0 ? 0 : sum;

        }
        return max;
    }

    static public void main(String[] args) {
        Solution s = new Solution();
        int ans = s.FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
    }

}
