package com.leet;


import com.leetcode.TreeNode;

/**
 * @author Fafnir
 * @date 2023/6/28
 */
public class LeetCode109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode low = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = low;
            low = low.next;
            fast = fast.next.next;
        }
        pre.next = null;

        TreeNode root = new TreeNode(low.val);
        root.right = sortedListToBST(low.next);
        root.left = sortedListToBST(head);
        return root;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }
}
