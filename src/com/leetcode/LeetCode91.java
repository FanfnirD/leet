package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/5/9
 */
public class LeetCode91 {

    public static void main(String[] args) {
        numDecodings("226");
    }

    public static int numDecodings(String s) {
        return dp2(s, 0, s.length(), new int[s.length() + 1]);
    }

    // 暴力解法
    public static int dp1(String str, int index, int len) {
        if (len == index) {
            return 1;
        }
        if (index > len || str.charAt(index) == '0') {
            return 0;
        }

        int result = 0;
        if (str.charAt(index) == '1') {
            result += dp1(str, index + 2, len);
        } else if (str.charAt(index) == '2' && index + 1 < len && str.charAt(index + 1) <= '6') {
            result += dp1(str, index + 2, len);
        }
        result += dp1(str, index + 1, len);
        return result;
    }

    /**
     * 记忆法
     * @param str
     * @param index
     * @param len
     * @param cache
     * @return
     */
    public static int dp2(String str, int index, int len, int[] cache) {
        if (len == index) {
            cache[index] = 1;
            return 1;
        }
        if (index > len || str.charAt(index) == '0') {
            return 0;
        }
        if (cache[index] != 0) {
            return cache[index];
        }


        int result = 0;
        if (str.charAt(index) == '1') {
            result += dp2(str, index + 2, len, cache);
        } else if (str.charAt(index) == '2' && index + 1 < len && str.charAt(index + 1) <= '6') {
            result += dp2(str, index + 2, len, cache);
        }
        result += dp2(str, index + 1, len, cache);
        cache[index] = result;
        return result;
    }



}
