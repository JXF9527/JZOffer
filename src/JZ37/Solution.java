package JZ37;


public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int low = 0, high = array.length - 1;
        int mid = 0, midval;
        int ans = 0;
        while (low <= high) {
            mid = (low + high) >> 1;
            midval = array[mid];
            if (midval > k) {
                high = mid - 1;
            }
            else if (midval < k) {
                low = mid + 1;
            }
            else {
                ++ans;
                break;
            }
        }

        if (ans > 0) {
            low = mid - 1;
            high = mid + 1;
            while (low >= 0 && array[low] == k) {
                ++ans;
                --low;
            }

            while (high < array.length && array[high] == k) {
                ++ans;
                ++high;
            }
        }

        return ans;
    }
}
