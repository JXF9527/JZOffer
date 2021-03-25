package JZ35;


public class Solution {
    private int ans = 0;

    //归并思想，在合并左右两组有序数组时，统计逆序对
    public int InversePairs(int [] array) {
        if (array.length <= 1)
            return 0;
        sort(array, 0, array.length - 1);
        return ans % 1000000007;
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int mid = start + ((end - start) >> 1);   //防溢出
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            }
            else {
                //此时i~mid都比j大，均组成逆序对
                temp[k++] = array[j++];
                ans = (ans + mid - i + 1) % 1000000007;
            }
        }

        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= end)
            temp[k++] = array[j++];

        //覆盖
        for (int n = 0; n < temp.length; n++) {
            array[start + n] = temp[n];
        }

    }
}
