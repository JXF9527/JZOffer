package JZ7;

public class Solution {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        int ans = 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; ++i) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }
}
