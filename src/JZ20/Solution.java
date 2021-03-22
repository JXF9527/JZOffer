package JZ20;


import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    Stack<Integer> stack = new Stack<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public void push(int node) {
        stack.push(node);
        if (map.containsKey(node)) {
            map.put(node, map.get(node) + 1);
        }
        else
            map.put(node, 1);
    }

    public void pop() {
        int node = stack.pop();
        int num = map.get(node);

        if (num > 1)
            map.put(node, map.get(node) - 1);
        else
            map.remove(node);

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return map.firstKey();
    }
}
