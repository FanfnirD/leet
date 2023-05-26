package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/8
 */
public class LeetCode2553 {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        int[] res =  new int[sb.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = sb.charAt(i) - '0';
        }
        return res;
    }
}
