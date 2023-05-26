package com.leet;

/**
 * @author Fafnir
 * @date 2023/5/23
 */
public class LeetCode961 {
    public int repeatedNTimes(int[] nums) {
        int[] cache = new int[10010];
        int res = -1;
        for (int num : nums) {
            if (++cache[num] > 1) {
                res = num;
                break;
            }
        }
        return res;
    }
}
