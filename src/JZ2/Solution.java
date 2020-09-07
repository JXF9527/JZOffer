package JZ2;

public class Solution {
    public String replaceSpace2(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    /**
     * 从前往后遍历，建立新串
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer buffer = new StringBuffer();
        for (char c : str.toString().toCharArray()) {
            if (c == ' ') {
                buffer.append("%20");
            }
            else {
                buffer.append(c);
            }
        }

        return buffer.toString();
    }
}