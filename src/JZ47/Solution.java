package JZ47;

public class Solution {
    //用逻辑与的短路特性直接控制
    public int Sum_Solution(int n) {
        int sum = n;
        Boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;

    }

    static public void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.Sum_Solution(5);
    }
}
