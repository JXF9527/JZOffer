package JZ32;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        StringBuffer ans = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length(), len2 = o2.length();
                int lim = Math.max(len1, len2);
                char c1 = 0, c2 = 0;
                for (int k = 0; k < lim; k++) {
                    if (k < len1 && k < len2) {
                        c1 = o1.charAt(k);
                        c2 = o2.charAt(k);
                    }
                    else {
                        if (k >= len1) {
                            c2 = o2.charAt(k);
                        }
                        if (k >= len2) {
                            c1 = o1.charAt(k);
                        }
                    }
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                }
                return len1 - len2;
            }
        });

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ans.append(it.next());
        }

        return ans.toString();
    }

    static public void main(String[] args) {
        Solution s = new Solution();
        String ans = s.PrintMinNumber(new int[]{3,32,321});
    }
}
