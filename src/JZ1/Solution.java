package JZ1;

public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array.length == 0)
            return false;
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target)
                return true;
            else if (array[i][j] > target) {
                --j;
            }
            else {
                ++i;
            }
        }

        return false;
    }
}