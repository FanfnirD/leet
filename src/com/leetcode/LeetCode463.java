package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/3
 */
public class LeetCode463 {

    public int islandPerimeter(int[][] grid) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, y, x);
                }
            }
        }
        return 0;

    }


    public int dfs(int[][] grid, int y, int x) {
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length) {
            return 1;
        }
        if (grid[y][x] == 0) {
            return 1;
        }
        if (grid[y][x] != 1) {
            return 0;
        }
        grid[y][x] = 2;
        return dfs(grid, y - 1, x)
                + dfs(grid, y + 1, x)
                + dfs(grid, y, x - 1)
                + dfs(grid, y, x + 1);
    }
}
