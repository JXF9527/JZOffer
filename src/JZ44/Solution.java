package JZ44;

public class Solution {
    public String ReverseSentence(String str) {
        String[] sa = str.split(" ");
        StringBuffer ans = new StringBuffer();
        if (sa.length == 0)
            ans.append(str);
        for (int i = sa.length - 1; i >= 0; --i) {
            ans.append(sa[i]);
            if (i != 0)
                ans.append(' ');
        }
        return ans.toString();
    }
}
