package JZ43;

public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0)
            return "";
        StringBuffer ans = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        char[] arrays = str.toCharArray();
        int i = 0;
        n = n % str.length();
        for (i = 0; i < n; i++) {
            temp.append(arrays[i]);
        }

        for (int j = i; j < arrays.length; ++j) {
            ans.append(arrays[j]);
        }
        ans.append(temp);

        return ans.toString();
    }
}
