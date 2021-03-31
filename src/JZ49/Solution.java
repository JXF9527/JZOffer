package JZ49;

public class Solution {
    public int StrToInt(String str) {
        char[] carray = str.toCharArray();
        if (carray.length < 1)
            return 0;
        char c = carray[0];
        if (carray.length == 1) {
            if (c >= '0' && c <= '9')
                return c - '0';
            else
                return 0;
        }
        int ans = 0, power = 1;
        for (int i = carray.length - 1; i >= 0; --i) {
            c = carray[i];
            if (c >= '0' && c <= '9') {
                ans += (c - '0') * power;
            }
            else if (c == '+' || c == '-') {
                if (i != 0)
                    return 0;
                else {
                    if (c == '-')
                        ans *= -1;
                }
            }
            else
                return 0;
            power *= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.StrToInt("la78");
    }
}
