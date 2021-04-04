package JZ52;

import java.util.*;
import java.util.regex.Pattern;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public boolean match (String str, String pattern) {
        // write code here
        char[] sa = str.toCharArray();
        char[] pa = pattern.toCharArray();
        int i = 0, j = 0;
        if (sa.length == 0 && pa.length == 0)
            return true;
        if (sa.length > 0 && pa.length == 0)
            return false;
        if (sa.length == 0 && pa.length != 0) {
            if (pa.length < 2)
                return false;
            else {
                if (pa.length % 2 != 0)
                    return false;
                for (i = 0; i < pa.length; i += 2) {
                    if (pa[i + 1] != '*')
                        return false;
                }
                return true;
            }
        }
        for (i = 0; i < sa.length; i++) {

            if (sa[i] != pa[j]) {
                switch (pa[j]) {
                    case '.':
                        ++j;
                        if (j >= pa.length && i < sa.length - 1)
                            return false;
                        break;
                    case '*':
                        if (pa[j - 1] != sa[i] && pa[j - 1] != '.') {
                            ++j;
                            if (j >= pa.length && i < sa.length - 1)
                                return false;
                            --i;
                        }
                        break;
                    default:
                        if (j < pa.length - 1) {
                            if (pa[j + 1] != '*')
                                return false;
                            else {
                                j += 2;
                                if (j >= pa.length && i < sa.length - 1)
                                    return false;
                                --i;
                            }
                        }
                        else
                            return false;
                        break;
                }
            }
            else {
                ++j;
                if (j >= pa.length && i < sa.length - 1)
                    return false;
            }

        }
        if (j < pa.length - 1)
            return false;
        else if (j == pa.length - 1 && pa[j] != '*')
            return false;
        return true;
    }

    public boolean match2 (String str, String pattern) {
        return str.matches(pattern);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean ans = solution.match2("aaa", "a*a");

    }
}
