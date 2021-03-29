package JZ42;

import java.util.ArrayList;

import java.util.HashSet;


public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                if (ans.size() > 0) {
                    if (array[i] * (sum - array[i]) < ans.get(0) * ans.get(1)) {
                        ans.clear();
                    }
                    else
                        continue;
                }

                ans.add(sum - array[i]);
                ans.add(array[i]);

            }
            else {
                set.add(sum - array[i]);
            }
        }

        return ans;
    }
}
