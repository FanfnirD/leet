package com.leet;

import java.util.Arrays;

/**
 * @author Fafnir
 * @date 2023/5/23
 */
public class LeetCode64 {

    public static void main(String[] args) {
        LeetCode64 leetCode64 = new LeetCode64();
        int i = leetCode64.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
        System.out.println(
                i
        );
    }

    //public int minPathSum(int[][] grid) {
    //
    //    return dp(grid, grid.length - 1, grid[0].length - 1);
    //}
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return Integer.MAX_VALUE;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        for (int[] x : cache) {
            Arrays.fill(x, -1);
        }
        return dp1(grid, m - 1, n - 1, cache);
    }

    public int dp(int[][] grid, int m, int n) {
        if (m >= grid.length || m < 0 || n >= grid[0].length || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        return grid[m][n] + Math.min(dp(grid, m - 1, n), dp(grid, m, n - 1));
    }

    public int dp1(int[][] grid, int m, int n, int[][] cache) {
        if (m >= grid.length || m < 0 || n >= grid[0].length || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (cache[m][n] != -1) {
            return cache[m][n];
        }
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        cache[m][n] = grid[m][n] + Math.min(dp1(grid, m - 1, n, cache), dp1(grid, m, n - 1, cache));
        return cache[m][n];
    }


    public int minPathSum1(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
