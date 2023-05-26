package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/24
 */
public class LeetCode713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }
        int ans = 0;
        int left = 0;

        int prod = 1;
        for (int right = 1; right <= nums.length; right++) {
            prod *= nums[right - 1];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left;
        }
        return ans;
    }
}
