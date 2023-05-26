package com.leetcode;
//
//你一个整数数组 nums，有一个大k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//        返回 滑动窗口中的最大值 。

import java.util.LinkedList;

public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();

        int n = nums.length;

        int[] res = new int[n - k + 1];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            if (i >= k - 1) {
                res[idx++] = nums[deque.peek()];
            }


        }
        return res;
    }
}
