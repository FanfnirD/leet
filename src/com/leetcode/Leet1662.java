package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/6/15
 */
public class Leet1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) {
                return false;
            } else {
                if (j1 + 1 >= word1[i1].length()) {
                    i1++;
                    j1 = 0;
                } else {
                    j1++;
                }
                if (j2 + 1 >= word2[i2].length()) {
                    i2++;
                    j2 = 0;
                } else {
                    j2++;
                }
            }
        }
        return i1 == word1.length && i2 == word2.length;
    }
}
