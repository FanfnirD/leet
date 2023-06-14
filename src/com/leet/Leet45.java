package com.leet;

import java.util.IdentityHashMap;

/**
 * @author Fafnir
 * @date 2023/6/14
 */
public class Leet45 {
    public static int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }

        return dpWay(0, nums);
    }

    public static int dpWay(int index, int[] nums) {
        if (index == nums.length - 1) {
            return 0;
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index] && (i + index) < nums.length; i++) {
            ans = Math.min(dpWay(index + i, nums), ans);
        }

        return ans == Integer.MAX_VALUE ? ans : ans + 1;
    }

    public static int jump01(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;

        for (int i = dp.length - 2; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i] && (i + j) < nums.length; j++) {
                ans = Math.min(dp[i + j], ans);
            }
            dp[i] = ans == Integer.MAX_VALUE ? ans : ans + 1;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(jump01(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));
    }
}
