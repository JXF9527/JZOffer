package JZ40;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    /*
      异或结果为1，则两数必为1与0的组合，可据此分两组分别异或
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int[] ans = new int[2];
        int i, sum = 0, k = 0;
        for (i = 0; i < array.length; i++) {
            sum ^= array[i];
        }
        while ((sum & 1) != 1) {
            ++k;
            sum >>= 1;
        }
        sum = 0;
        int sum2 = 0;
        for (i = 0; i < array.length; i++) {
            if (((array[i] >> k) & 1) == 1) {
                sum ^= array[i];
            }
            else
                sum2 ^= array[i];
        }

        if (sum < sum2) {
            ans[0] = sum;
            ans[1] = sum2;
        }
        else  {
            ans[0] = sum2;
            ans[1] = sum;
        }

        return ans;
    }
}
