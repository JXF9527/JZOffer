package JZ23;

public class Solution {
    static public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        int left = 0, right = sequence.length - 1;
        return help(sequence, left, right);
    }

    static public boolean help(int[] sequence, int left, int right) {
        if (right - left < 2)
            return true;

        int midnum = sequence[right];
        int mid = 0;
        int count = 0;
        if (midnum < sequence[left])
            ++count;
        for (int i = left + 1; i <= right - 1; i++) {
            if (midnum > sequence[i - 1] && midnum < sequence[i]) {
                mid = i;
                ++count;
            }
            //完全逆序表示不符合后序
            if (midnum < sequence[i - 1] && midnum > sequence[i]) {
                return false;
            }
        }
        if (midnum > sequence[right - 1]) {
            mid = right - 1;
            ++count;
        }

        return (count == 1) && help(sequence, left, mid - 1) && help(sequence, mid, right - 1);
    }

    static public void main(String[] args) {
        boolean ans = VerifySquenceOfBST(new int[]{4,8,6,12,16,14,10});
    }
}
