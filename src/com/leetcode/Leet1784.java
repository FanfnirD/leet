package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/19
 */
public class Leet1784 {
    public static void main(String[] args) {
        checkOnesSegment("110");
    }

    public static boolean checkOnesSegment(String s) {
        String[] strs = s.split("0");

        return  strs.length == 1;

    }
}
