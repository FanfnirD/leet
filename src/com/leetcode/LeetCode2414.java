package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/19
 */
public class LeetCode2414 {
    public static void main(String[] args) {
        longestContinuousSubstring("abacaba");
    }

    public static int longestContinuousSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int[] cache = new int[27];
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            cache[s.charAt(right) - 'a'] = right;
            if (cache[s.charAt(right) - 'a']>cache[s.charAt(left)-'a']) {

                left = right;
            }

            max = Math.max(right - left + 1, max);

            right++;

        }
        return max;
    }
}
