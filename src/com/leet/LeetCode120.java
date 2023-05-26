package com.leet;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Fafnir
 * @date 2023/5/26
 */
public class LeetCode120 {


    public static void main(String[] args) {

        ArrayList<List<Integer>> tri = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));
        tri.add(list1);
        tri.add(list2);
        tri.add(list3);
        tri.add(list4);
        System.out.println(new LeetCode120().minimumTotal(tri));
    }

/*    public int minimumTotal(List<List<Integer>> triangle) {
        return dp(triangle, 0, 0);
    }

    public int dp(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }

        if (triangle.get(row).size() <= col) {
            return Integer.MAX_VALUE;
        }
        Integer res = triangle.get(row).get(col);
        res += Math.min(dp(triangle, row + 1, col), dp(triangle, row + 1, col + 1));
        return res;
    }*/

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] mem = new int[m][n];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], Integer.MIN_VALUE);
        }

        return getMinimumTotal(0, 0, triangle, mem);
    }

    private int getMinimumTotal(int i, int j, List<List<Integer>> triangle, int[][] mem) {
        if (mem[i][j] != Integer.MIN_VALUE) {
            return mem[i][j];
        }
        Integer num = triangle.get(i).get(j);
        int ans;
        if (i == triangle.size() - 1) {
            ans = num;
        } else {
            ans = Math.min(getMinimumTotal(i + 1, j, triangle, mem), getMinimumTotal(i + 1, j + 1, triangle, mem)) + num;
        }
        mem[i][j] = ans;
        return ans;
    }
}
