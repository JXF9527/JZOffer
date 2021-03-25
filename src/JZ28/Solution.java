package JZ28;

import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int mid = array.length / 2 + 1;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            }
            else
                map.put(array[i], 1);
            if (map.get(array[i]) >= mid)
                return array[i];
        }

        return 0;
    }
}
