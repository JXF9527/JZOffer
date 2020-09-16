package JZ11;

public class Solution {
    static public int NumberOf1(int n) {
        int c = 32;
        int count = 0;
        while (c-- > 0) {
            if ((n & 1) == 1) {
                ++count;
            }
            n = n >>> 1;
        }

        return count;
    }
    static public void main(String[] args) {
        int c = NumberOf1(Integer.MIN_VALUE);
    }
}
