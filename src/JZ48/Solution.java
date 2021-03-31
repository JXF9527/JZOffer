package JZ48;

public class Solution {
    //按位异或和按位与实现加法
    public int Add(int num1,int num2) {
        int temp = num2;
        while (num1 != 0) {
            num2 = temp;
            temp = num1 ^ temp;
            num1 = (num1 & num2) << 1;   //求进位

        }

        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.Add(111,899);
    }
}
