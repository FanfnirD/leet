package com.leet;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Fafnir
 * @date 2023/5/29
 */
public class LeetCode1091 {

        public int shortestPathBinaryMatrix(int[][] grid) {
            // 起点不为0，不满足畅通路径条件，直接返回-1
            if(grid[0][0] == 1){
                return -1;
            }
            int n = grid.length;    // 矩阵大小
            int[][] dist = new int[n][n];   // 记录每个节点到起点的最短畅通路径
            dist[0][0] = 1;                 // 起点长度初始为1
            Queue<int[]> queue = new LinkedList<>();    // BFS使用的队列
            queue.offer(new int[]{0, 0});               // 初始将起点坐标入队
            int[] g;    // 每次搜索得到的坐标数组
            int r;      // 每次搜索的行坐标
            int c;      // 每次搜索的列坐标
            while(!queue.isEmpty()){
                g = queue.poll();   // 弹出队首坐标
                r = g[0];
                c = g[1];
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        // 枚举9个方向，跳过本身（i=0，j=0）
                        // 跳过越界坐标
                        // 跳过值为1的坐标
                        // 跳过遍历过的坐标
                        if((i == 0 && j == 0) || r + i < 0 || r + i >= n || c + j < 0 || c + j >= n || grid[r + i][c + j] == 1 || dist[r + i][c + j] > 0){
                            continue;
                        }
                        dist[r + i][c + j] = dist[r][c] + 1;    // 更新新坐标的距离等于当前坐标距离 + 1
                        queue.offer(new int[]{r + i, c + j});   // 新坐标入队
                    }
                }
            }
            return dist[n - 1][n - 1] == 0 ? -1 : dist[n - 1][n - 1];   // 终点坐标的值为0，说明不可达返回-1；否则返回记录的值

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
