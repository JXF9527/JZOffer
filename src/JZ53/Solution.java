package JZ53;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return bool布尔型
     */
    public boolean isNumeric (String str) {
        // write code here
        double ans;
        try {
            ans = Double.valueOf(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean ans = solution.isNumeric("-1E-16");
    }
}
