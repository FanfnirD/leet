package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/28
 */
public class LeetCode633 {

    public boolean judgeSquareSum(int c) {

        long low = 0;
        long hight = (long) Math.sqrt(c);

        while (low <= hight) {
            long sum = low * low + hight * hight;
            if (sum == c){
                return true;
            } else if (sum<c) {
                low++;
            }else {
                hight--;
            }
        }
        return false;
    }
}
