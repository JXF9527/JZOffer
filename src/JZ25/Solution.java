package JZ25;


import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    //所有label数据不同
    static public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode node = null;
        RandomListNode newHead = null;
        RandomListNode newN = null, newP = null;

        HashMap<RandomListNode, Integer> map = new HashMap<>();
        HashMap<Integer, RandomListNode> nMap = new HashMap<>();

        int num = 0;
        node = pHead;
        while (node != null) {
            map.put(node, num);
            newN = new RandomListNode(node.label);
            nMap.put(num, newN);
            ++num;
            if (newP == null) {
                newHead = newN;
            }
            else {
                newP.next = newN;
            }
            newP = newN;
            node = node.next;
        }

        node = pHead;
        newN = newHead;
        while (node != null) {
            newN.random = nMap.get(map.get(node.random));

            node = node.next;
            newN = newN.next;
        }

        return newHead;
    }

    static public void main(String[] args) {
        RandomListNode test1 = new RandomListNode(1);
        RandomListNode test2 = new RandomListNode(2);
        test1.next = test2;
        test1.random = test2;
        test2.random = test1;
        RandomListNode ans = Clone(test1);
    }

}
