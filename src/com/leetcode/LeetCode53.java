package com.leetcode;

import java.util.Currency;

/**
 * @author fafnirH
 * @date 2023/4/28
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {


        int count = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0 && count <= 0) {
                count = nums[i];
            } else if (nums[i] <= 0) {
                count += nums[i];
            } else if (nums[i] >= 0 && count <= 0) {
                count = nums[i]; // 如果当前元素大于 0，且前面的连续子序列的和小于等于 0，则以当前元素更新连续子序列的起点
            } else if (nums[i] >= 0) {
                count = nums[i] + count;// 如果当前元素大于 0，且前面的连续子序列的和也大于 0，则将当前元素加入连续子序列中，加入后更大
            }
            max = Math.max(count, max);

        }
        return max;
    }
}
