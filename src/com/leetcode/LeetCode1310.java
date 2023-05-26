package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/26
 */
public class LeetCode1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {

        int n = arr.length;
        int m = queries.length;
        // 前缀异或和数组
        int[] sum = new int[n + 1];

        int[] res = new int[m];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0] + 1;
            int r = queries[i][1] + 1;
            res[i] = sum[r] ^ sum[l - 1];
        }
        return res;

    }
}
