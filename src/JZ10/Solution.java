package JZ10;

public class Solution {
    //1 2 3 4 5 6 7 8 9
    //1 2 3 5
    public int RectCover(int target) {
        if (target <= 2)
            return target;
        int a = 1, b = 2;
        int ans = b;
        target -= 2;
        while (target-- > 0) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }
}
