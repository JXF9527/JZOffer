package JZ33;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    //在三个队列中分别乘2、3、5，取最小加入丑数数组
    public int GetUglyNumber_Solution(int index) {
        if (index <= 5)
            return index;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, k = 0;    //用位置获得当前队列最小值
        int mi, mj, mk;
        ans.add(1);
        while (ans.size() < index) {
            mi = ans.get(i) * 2;
            mj = ans.get(j) * 3;
            mk = ans.get(k) * 5;
            if (mi < mj) {
                if (mi < mk) {
                    i = add(ans, mi, i);
                }
                else {
                    k = add(ans, mk, k);
                }
            }
            else {
                if (mj < mk) {
                    j = add(ans, mj, j);
                }
                else {
                    k = add(ans, mk, k);
                }
            }
        }

        return ans.get(index - 1);
    }

    private int add(ArrayList<Integer> ans, int value, int pos) {
        //查重
        if (ans.get(ans.size() - 1) != value) {
            ans.add(value);
        }
        return pos + 1;
    }

    //2 3 5 | 4 6 10 | 9 15 | 25
    //2 3 5 | 4 6 9 10 15 25 | 8 12 18 20 30 50/ 12 18 27 30 45 75/ 20 30 45 50 75 125
    public int GetUglyNumber_Solution2(int index) {
        if (index <= 5)
            return index;
        int count = 6;
        int value = 6;
        int t;
        Set<Integer> target = new HashSet<>();
        target.add(1);
        target.add(2);
        target.add(3);
        target.add(4);
        target.add(5);

        while (count <= index) {
            t = value;
            if (t != 1) {
                if (t % 2 == 0) {
                    t /= 2;
                    if (target.contains(t))
                        t = 1;
                }
                if (t % 3 == 0) {
                    t /= 3;
                    if (target.contains(t))
                        t = 1;
                }
                if (t % 5 == 0) {
                    t /= 5;
                    if (target.contains(t))
                        t = 1;
                }
            }

            if (t == 1) {
                ++count;
                target.add(value);
            }
            ++value;
        }

        return value - 1;
    }




    static public void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.GetUglyNumber_Solution(20);
    }
}
