package JZ50;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        // write code here
        int ans = -1;
        int i;
        for (i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
                return -1;
        }
        //* (-1)标记，如果当前元素已经是负数，则表示重复
        int t;
        for (i = 0; i < numbers.length; i++) {
            t = numbers[i] > 0 ? numbers[i] : -numbers[i];
            if (numbers[t] < 0) {
                return t;
            }
            numbers[t] = - numbers[t];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.duplicate(new int[]{2,1,3,1,4});
    }
}
