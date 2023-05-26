package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/8
 */
public class LeetCode17_10 {
    /**
     * 摩尔投票法 找出数组中的众数
     * 每次将两个不同的元素进行抵消，如果最后又元素甚于，则可能为元素大于总数一半的那个。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int n = nums.length;
        int x = -1;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                x = num;
                cnt = 1;
            } else {
                cnt += x == num ? 1 : -1;
            }
        }// 找出众数
        cnt = 0;
        for (int i : nums) {
            if (x == i) cnt++;
        }
        return cnt > n / 2 ? x : -1;


    }
}
