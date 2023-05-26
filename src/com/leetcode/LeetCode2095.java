package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/4
 */
public class LeetCode2095 {
    public ListNode deleteMiddle(ListNode head) {
        //快慢指针
        ListNode slow = head,fast = head.next;
        if(fast == null) return null;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}
