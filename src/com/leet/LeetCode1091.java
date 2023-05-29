package com.leet;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Fafnir
 * @date 2023/5/29
 */
public class LeetCode1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        grid[0][0] = 1;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        for (int ans = 1; !q.isEmpty(); ++ans) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                int i = p[0], j = p[1];
                if (i == n - 1 && j == n - 1) {
                    return ans;
                }
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                            grid[x][y] = 1;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return -1;

    }



    public int baseDP(int[][] grid, int R, int C) {

        int n = grid.length;
        int m = grid[0].length;
        if (R > n || R < 0 || C > m || C < 0) {
            return -1;
        }
        if (grid[R][C] == 1) {
            return -1;
        }
        if (R == 0 && C == 0) {
            return 1;
        }

        int ans = -1;
        grid[R][C] = 1;



        if (R + 1 < n && C < m && grid[R + 1][C] == 0) {
            int info = baseDP(grid, R + 1, C);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R + 1][C] = 0;
        }
        if (R + 1 < n && C + 1 < m && grid[R + 1][C + 1] == 0) {
            int info = baseDP(grid, R + 1, C + 1);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R + 1][C + 1] = 0;
        }
        if (R < n && C + 1 < m && grid[R][C + 1] == 0) {
            int info = baseDP(grid, R, C + 1);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R][C + 1] = 0;
        }
        if (R - 1 >= 0 && C + 1 < m && grid[R - 1][C + 1] == 0) {
            int info = baseDP(grid, R - 1, C + 1);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R - 1][C + 1] = 0;
        }
        if (R - 1 >= 0 && C < m && grid[R - 1][C] == 0) {
            int info = baseDP(grid, R - 1, C);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R - 1][C] = 0;
        }
        if (R - 1 >= 0 && C - 1 >= 0 && grid[R - 1][C - 1] == 0) {
            int info = baseDP(grid, R - 1, C - 1);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R - 1][C - 1] = 0;
        }
        if (R < n && C - 1 >= 0 && grid[R][C - 1] == 0) {
            int info = baseDP(grid, R, C - 1);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R][C - 1] = 0;
        }
        if (R + 1 < n && C - 1 >= 0 && grid[R + 1][C - 1] == 0) {
            int info = baseDP(grid, R + 1, C - 1);
            ans = ans == -1 ? info : Math.min(info, ans);
            grid[R + 1][C - 1] = 0;
        }

        return ans == -1 ? ans : ans + 1;

    }
}
