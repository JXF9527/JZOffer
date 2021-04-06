package JZ64;

import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size > num.length)
            return ans;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < num.length; i++) {
            if (queue.size() < size) {
                queue.add(num[i]);
            }
            else {
                queue.remove(num[i - size]);
                queue.add(num[i]);

            }
            if (queue.size() == size) {
                ans.add(queue.peek());

            }
        }

        return ans;
    }

    /**
     * 双端队列
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size > num.length || size == 0)
            return ans;
        Deque<Integer> deque = new LinkedList<>();
        int i;
        for (i = 0; i < num.length; i++) {
            if (!deque.isEmpty()) {
                //删除过期元素
                if (deque.peek() + size <= i)
                    deque.poll();

                //删除小队尾
                while (!deque.isEmpty() && num[i] >= num[deque.getLast()])
                    deque.removeLast();
            }
            deque.addLast(i);

            if (i >= size - 1)
                ans.add(num[deque.peek()]);
        }

        return ans;
    }
}
