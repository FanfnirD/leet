package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fafnirH
 * @date 2023/4/19
 */
public class LeetNode04_03 {




    public char findTheDifference(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        for (int i = 0; i < str1.length; i++) {
            sum1 += Integer.valueOf(str1[i]);
            sum2 += Integer.valueOf(str2[i]);
        }
        sum2 += Integer.valueOf(str2[str2.length - 1]);
        return (char) (sum2 - sum1);
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ListNode> resultList = new ArrayList<>();


        queue.push(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode tmpHead = new ListNode(-1);
            ListNode dummy = tmpHead;
            for (int i = 0; i < size; i++) {
                var node = queue.pollFirst();
                tmpHead.next = new ListNode(node.val);
                tmpHead = tmpHead.next;

                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }

            resultList.add(dummy.next);
        }
        ListNode[] retArr = new ListNode[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            retArr[i] = resultList.get(i);
        }


        return retArr;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}