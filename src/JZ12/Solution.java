package JZ12;

public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        double ans = 1.0;
        boolean zf = false;
        if (exponent < 0) {
            zf = true;
            exponent = -exponent;
        }
        while (exponent-- > 0) {
            ans *= base;
        }
        if (zf)
            ans = 1 / ans;
        return ans;
    }
}
