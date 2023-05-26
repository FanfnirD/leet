package com.leetcode;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author fafnirH
 * @date 2023/4/3
 */
public class LeetCode0104 {

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        int odd = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                if (++odd > 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
