package JZ41;

import java.util.ArrayList;
public class Solution {
    //1 2 3 4 5 6 7 8
    //3 + 2n，6 + 3n,…… k(k+1)/2 + kn，长度为k的连续序列和的值
    //(根号(8 * sum +1) - 1)/2 = 最大连续序列长度
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (sum < 3)
            return ans;
        ArrayList<Integer> list = new ArrayList<>();
        int max = (int)((Math.sqrt(8 * sum + 1) - 1) / 2);
        int s = 0, sm = 0;
        for (int i = max; i >= 2; --i) {
            s = (i * (i + 1)) / 2;
            if ((sum - s) % i == 0) {
                sm = (sum - s) / i;
                for (int j = sm + 1; j <= sm + i; ++j) {
                    list.add(j);
                }
                ans.add((ArrayList<Integer>) list.clone());
                list.clear();
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> ans = solution.FindContinuousSequence(9);
    }
}
