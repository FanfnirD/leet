package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/9
 */
public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode p = head;
        int count = 1;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        p.next = head;//成环
        //节点定位，然后拆开
        for (int i = 0; i < count - k - 1; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        //拆开环
        head.next = null;
        return newHead;
    }
}
