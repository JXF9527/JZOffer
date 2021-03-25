package JZ27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Solution {

    private ArrayList<String> ans = new ArrayList<>();
    private StringBuffer outbuf = new StringBuffer();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ans;
        char[] arrays = str.toCharArray();
        Arrays.sort(arrays);
        outbuf.append(arrays);
        help("");

        ans.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //与相邻字符串查重
        if (ans.size() > 1) {
            for (int i = 0; i < ans.size() - 1; i++) {
                if (ans.get(i).equals(ans.get(i + 1))) {
                    ans.remove(i + 1);
                    --i;
                }
            }
        }
        return ans;
    }

    private void help(String inbuf) {
        if (outbuf.length() == 0) {
            ans.add(inbuf);
            return;
        }

        char c;

        for (int i = 0; i < outbuf.length(); i++) {
            c = outbuf.charAt(i);
            outbuf.deleteCharAt(i);
            help(inbuf + c);
            outbuf.insert(i,c);
        }

    }

    static public void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> ans = solution.Permutation("ab");
    }

}
