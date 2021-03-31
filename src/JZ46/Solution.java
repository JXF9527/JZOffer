package JZ46;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        int[] addr = new int[n];   //数组链表
        for (int i = 0; i < addr.length; i++) {
            addr[i] = (i + 1) % n;
        }
        if (n == 0 || m > n)
            return -1;
        int num = n, i = 0, k = 0, pre = n - 1;
        while (num > 1) {
            if (k == m - 1) {
                num--;
                k = -1;
                addr[pre] = addr[i];
            }
            ++k;
            pre = i;
            i = addr[i];
        }
        return i;
    }

    static public void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.LastRemaining_Solution(5, 3);
    }

}
