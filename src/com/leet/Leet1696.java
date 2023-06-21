package com.leet;

import java.util.Arrays;

/**
 * @author Fafnir
 * @date 2023/6/21
 */
public class Leet1696 {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomArr();
            int k = (int) (Math.random() * 10) + 1;
            System.out.println(Arrays.toString(arr));
            System.out.println( maxResult(arr,k) == dpWay(arr,k) ? "great" : "fuck!!!");
        }

    }

    public static int[] RandomArr() {
        int len = (int) (Math.random() * 50)+1;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) - (int) (Math.random() * 100);
        }
        return arr;

    }

    public static int maxResult(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process0(nums, k, 0);
    }


    public static int process0(int[] nums, int k, int index) {
        if (index == nums.length - 1) {
            return nums[index];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= k && index + i < nums.length; i++) {
            res = Math.max(process0(nums, k, index + i), res);
        }
        return res == Integer.MIN_VALUE ? res : res + nums[index];
    }

    public static int dpWay(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[n-1] = nums[n-1];
        for (int index = n - 2; index >= 0; index--) {

            for (int i = 1; i <= k && (index + i) < n; i++) {
                dp[index] = Math.max(dp[index + i], dp[index]);
            }
            dp[index] = dp[index] == Integer.MIN_VALUE ? dp[index] : dp[index] + nums[index];

        }
        return dp[0];
    }

    public static int maxResult1(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        // dp[i] = 到达i位置可得的最大分数
        int[] dp = new int[length];
        // 初始化除0外的所有值为最小
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < length; i++) {
            // dp[i]可到达的所有位置
            for (int j = i + 1; j < length && j <= i + k; j++) {
                // 从i跳跃到j位置, j位置的最大得分
                int nextNum = dp[i] + nums[j];
                // 如果比j位置当前最大得分大, 则更新j位置最大得分
                if (dp[j] < nextNum) {
                    dp[j] = nextNum;
                }
                // 剪枝, i后面能影响到的分数, 可以由遍历到j时进行更新
                if (dp[j] >= dp[i]) {
                    break;
                }
            }
        }
        return dp[length - 1];
    }


}
