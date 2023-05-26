package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/28
 */
public class LeetCode1446 {
    public static void main(String[] args) {
        new LeetCode1446().maxPower("leetcode");
    }

    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(left) ) {
                count++;

            } else {
                left = i;
                count = 1;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
