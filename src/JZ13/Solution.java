package JZ13;

import java.util.*;

public class Solution {
    static public int[] reOrderArray (int[] array) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] %2 != 0) {
                list1.add(array[i]);
            }
            else {
                list2.add(array[i]);
            }
        }
        list1.addAll(list2);
        int[] ans = new int[array.length];
        Iterator<Integer> it = list1.iterator();
        for (int i = 0; i < array.length; i++) {
            ans[i] = it.next();
        }
        return ans;
    }
    static public void reOrderArray2(int[] array) {
        Queue<Integer> queue = new LinkedList<>();
        int temp = 0;
        int pos = 0;
        int i;
        int j = 0;
        for (i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                ++j;
            }

        }

        for (i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                ++j;
            }

        }
    }

    static public void main(String[] args) {
        int[] ans = reOrderArray(new int[] {1,2,3,4,5,6,7});
    }
}
