package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/12
 */
public class LeetCode645 {
    public int[] findErrorNums(int[] nums) {
        int[] cache = new int[Integer.MAX_VALUE];
        for (int num : nums) {
            cache[num - 1]++;
            if (cache[num - 1] >= 2) {
                return new int[]{num, num + 1};
            }
        }
        return new int[]{};
    }
}
