package com.leetcode;

import java.util.Arrays;

/**
 * @author Fafnir
 * @date 2023/5/16
 */
public class LeetCode2500 {

    public int deleteGreatestValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // 遍历每一行
        for(int i=0;i<m;i++){
            // 按行排序
            Arrays.sort(grid[i]);
        }

        int maxSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            maxSum += max;
        }
        return maxSum;
    }
}
