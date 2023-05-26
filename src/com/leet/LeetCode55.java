package com.leet;

import java.util.Arrays;

/**
 * @author Fafnir
 * @date 2023/5/24
 */
public class LeetCode55 {
    public static void main(String[] args) {
        LeetCode55 code = new LeetCode55();
        System.out.println(code.canJump1(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        return dp(nums, 0, nums.length - 1);
    }

    public boolean dp(int[] nums, int index, int target) {
        if (index == target) {
            return true;
        }
        if (index > target || nums[index] == 0) {
            return false;
        }

        boolean flag = false;
        for (int i = nums[index]; i > 0; i--) {
            flag |= dp(nums, index + i, target);
        }
        return flag;
    }

    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dp1(nums, 0, nums.length - 1, cache);
    }

    public boolean dp1(int[] nums, int index, int target, int[] cache) {
        if (index == target) {
            return true;
        }

        if (index > target || nums[index] == 0) {
            return false;
        }

        if (cache[index] != -1) {
            return cache[index] == 0 ? false : true;
        }

        boolean flag = false;
        for (int i = nums[index]; i > 0; i--) {
            flag |= dp1(nums, index + i, target, cache);
            if (flag) {
                break;
            }
        }
        cache[index] = flag ? 1 : 0;
        return flag;
    }

    /**
     * 从下标ii出发，能到达的位置是nums[i]+inums[i]+i
     * 不从下标ii出发，最大能到达的就是dp[i-1]dp[i−1]
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if (dp[i] >= nums.length - 1) {
                return true;
            }
            if (dp[i] == i) {
                return false;
            }
        }
        return true;
    }

}
