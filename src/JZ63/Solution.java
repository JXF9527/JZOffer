package JZ63;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //使用大顶堆和小顶堆将数据分为两半，大顶堆存小元素、小顶堆存大元素，中位数可直接从堆顶元素获得
    private PriorityQueue<Integer> highp = new PriorityQueue<>();  //小顶堆
    private PriorityQueue<Integer> lowp = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            if (lowp.size() > 0) {
                if (num > highp.peek())
                    highp.add(num);
                else
                    lowp.add(num);
            }
            else
                lowp.add(num);
        }
        else {
            int t;
            if (lowp.size() > highp.size()) {
                t = lowp.peek();
                if (num >= t) {
                    highp.add(num);
                }
                else {
                    highp.add(lowp.poll());
                    lowp.add(num);
                }
            }
            else {
                t = highp.size();
                if (num <= t) {
                    lowp.add(num);
                }
                else {
                    lowp.add(highp.poll());
                    highp.add(num);
                }
            }
        }
        ++count;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (highp.peek() + lowp.peek()) / 2.0;
        }
        else {
            return Double.valueOf(lowp.size() > highp.size() ? lowp.peek() : highp.peek());
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = new int[]{5,2,3,4,1,6,7,0,8};
        for (int i = 0; i < ar.length; i++) {
            solution.Insert(ar[i]);
            System.out.print(solution.GetMedian() + " ");
        }

    }
}
