package JZ45;

import java.util.Arrays;

public class Solution {
    public boolean IsContinuous(int [] numbers) {
        if (numbers.length < 5)
            return false;
        Arrays.sort(numbers);
        int king = 0, i = 0;
        int pre = 0, s = 0;
        while (numbers[i] == 0) {
            ++king;
            ++i;
        }
        for (; i < numbers.length; i++) {
            if (pre != 0) {
                s = numbers[i] - pre;
                if (s > 1) {
                    king -= (s - 1);
                    if (king < 0)
                        return false;
                }
                else if (s == 0)
                    return false;
            }
            pre = numbers[i];

        }
        return true;
    }
}
