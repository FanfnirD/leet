package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/6/26
 */
public class LeetCode1011 {

    public boolean validCation(int[] weights, int days, int heights) {
        if (weights == null || days <= 0 || heights <= 0) {
            return false;
        }
        int count = 1;
        int singleWeight = weights[0];
        for (int i = 1; i < weights.length; i++) {
            singleWeight += weights[i];
            if (singleWeight > heights) {
                count++;
                singleWeight = weights[i];
            }
            if (count > days) {
                return false;
            }
        }
        return true;
    }


    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || days <= 0) {
            return 0;
        }

        int max = 0, sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        int left = max;
        int right = sum;

        while (right > left) {
            int mid = left + (right - left) / 2;
            if (validCation(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }


}
