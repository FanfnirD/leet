package com.leetcode;

public class LeetCode9 {

    public static void main(String[] args) {
        int x = -121;
        boolean palindrome = new LeetCode9().isPalindrome(x);
    }

    public boolean isPalindrome(int x) {

        String numStr = String.valueOf(x);


        int time = numStr.length() / 2;
        char[] chars = numStr.toCharArray();
        int left = 0;
        int right = numStr.length() - 1;
        while (time-- > 0) {
            if (chars[right--] != chars[left++]) {
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome01(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        return true;
    }
}
