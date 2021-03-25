package JZ34;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        HashMap<Character, Integer> hmap = new HashMap();
        HashSet<Character> dset = new HashSet<>();
        char[] ay = str.toCharArray();
        for (int i = 0; i < ay.length; i++) {
            if (hmap.containsKey(ay[i])) {
                dset.add(ay[i]);

            }
            else {
                hmap.put(ay[i], i);
            }
        }

        int ans = ay.length, ca = 0;
        Iterator<Map.Entry<Character, Integer>> it = hmap.entrySet().iterator();
        Map.Entry<Character, Integer> node;
        while (it.hasNext()) {
            node = it.next();
            ca = node.getValue();
            if (!dset.contains(node.getKey())) {
                ans = ans < ca ? ans : ca;
            }
        }

        return ans == ay.length ? -1 : ans;
    }

    //一遍存次数，二遍找第一个次数为1的字母
    public int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0)
            return -1;
        HashMap<Character, Integer> hmap = new HashMap();
        char[] ay = str.toCharArray();
        int i;
        for (i = 0; i < ay.length; i++) {
            if (hmap.containsKey(ay[i])) {
                hmap.put(ay[i], hmap.get(ay[i]) + 1);
            }
            else {
                hmap.put(ay[i], 1);
            }
        }

        for (i = 0; i < ay.length; i++) {
            if (hmap.get(ay[i]) == 1)
                return i;
        }
        return -1;
    }

    static public void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.FirstNotRepeatingChar("google");

    }
}
