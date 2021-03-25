package JZ29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    //排序取前k个
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k > input.length)
            return ans;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;

    }

    //用最大堆，重写compare的PriorityQueue，每次与堆顶比较，保留k个值，删除较大的堆顶，较小值入堆
}
