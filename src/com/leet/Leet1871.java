package com.leet;

/**
 * @author Fafnir
 * @date 2023/6/9
 */
public class Leet1871 {
    public static void main(String[] args) {
        Leet1871 leet1871 = new Leet1871();
        System.out.println(leet1871.canReach("011010", 2, 3));
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        return dp01(s.toCharArray(), 0, minJump, maxJump);
    }

    public boolean dp01(char[] strs, int index, int minJump, int maxJump) {
        if (index == strs.length) {
            return true;
        }
        boolean res = false;
        for (int j = index; j < strs.length-1; j += minJump) {
            if (index + minJump <= j + 1 && j + 1 <= Math.max(strs.length - 1, index + maxJump) && strs[j + 1] == '0') {
                res |= dp01(strs, j + 1, minJump, maxJump);
            }
        }
        return res;
    }
}
