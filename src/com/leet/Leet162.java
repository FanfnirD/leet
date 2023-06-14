package com.leet;

/**
 * @author Fafnir
 * @date 2023/6/14
 */
public class Leet162 {
    // 寻找峰值
    public static int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }


}
