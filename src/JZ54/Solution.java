package JZ54;

public class Solution {
    private StringBuffer buffer = new StringBuffer();
    private int[] counter = new int[256];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        buffer.append(ch);
        counter[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (char c : buffer.toString().toCharArray()) {
            if (counter[c] == 1)
                return c;
        }
        return '#';
    }
}
