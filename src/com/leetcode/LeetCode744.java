package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/16
 */
public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target < letters[0]) {
            return letters[0];
        }
        int n = letters.length;
        if (target > letters[n - 1]) {
            return letters[n - 1];
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < letters[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return letters[l % n];
    }
}
