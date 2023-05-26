package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/23
 */
public class LeetCode1494 {

    public int maxProduct(int[] nums) {
        if (nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }
        int maxIndex = nums[0] > nums[1] ? 0 : 1;
        int nextMaxIndex = maxIndex == 0 ? 1 : 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= nums[maxIndex]) {
                nextMaxIndex = maxIndex;
                maxIndex = i;
            } else {
                if (nums[i] > nums[nextMaxIndex]) {
                    nextMaxIndex = i;
                }
            }
        }

        return (nums[maxIndex] - 1) * (nums[nextMaxIndex] - 1);

    }




    static int mod = 1000000007;
    static int[] dp = new int[101];


    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (fib(n - 1) + fib(n - 2)) % mod;
        return dp[n];
    }

}
