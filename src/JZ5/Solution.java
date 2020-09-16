package JZ5;

import java.util.Stack;

public class Solution {
    //压入栈
    Stack<Integer> stack1 = new Stack<Integer>();
    //弹出栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }


}
