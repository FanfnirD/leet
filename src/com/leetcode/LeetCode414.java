package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/17
 */
public class LeetCode414 {
    public static void main(String[] args) {
        thirdMax(new int[]{3, 2, 2, 3, 1});
    }

    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        if(thirdMax == Integer.MIN_VALUE){
            return (int)firstMax;
        }else return (int)thirdMax;
    }
}
