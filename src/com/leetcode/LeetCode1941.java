package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/9
 */
public class LeetCode1941 {
    public static void main(String[] args) {
        areOccurrencesEqual("abacbc");
    }

    public static boolean areOccurrencesEqual(String s) {
        int[] cache = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i) - 'a']++;
        }

        int stand = cache[s.charAt(0) - 'a'];
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != 0 && stand != cache[i]) {
                return false;
            }
        }
        return true;
    }


}
