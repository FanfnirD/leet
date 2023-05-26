package com.leetcode;

import java.util.Arrays;

/**
 * @author fafnirH
 * @date 2023/4/4
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int[][] res = new int[intervals.length][2];
        int index = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                res[index][0] = start;
                res[index][1] = end;
                index++;

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res[index][0] = start;
        res[index][1] = end;
        return Arrays.copyOfRange(res, 0, index+1);
    }
}
