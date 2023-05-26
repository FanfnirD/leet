package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/12
 */
public class LeetCode628 {
    public static void main(String[] args) {
        int num = maximumProduct(new int[]{-100,-98,-1,2,3,4});
        System.out.println(num);
    }
    public static int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int greatest = Integer.MIN_VALUE;
        int secondGreat = greatest;
        int great = greatest;

        int smallest = Integer.MAX_VALUE;
        int secondSmall = smallest;

        for (int num : nums) {
            if (num > greatest) {
                // 比最大的大
                great = secondGreat;
                secondGreat = greatest;
                greatest = num;
            } else if (num > secondGreat) {
                great = secondGreat;
                secondGreat = num;
            } else if (num > great) {
                great = num;
            }

            if (num < smallest) {
                // 比最小还小
                secondSmall = smallest;
                smallest = num;
            } else if (num < secondSmall) {
                secondSmall = num;
            }
        }

        return Math.max(greatest * secondSmall * smallest, great * secondGreat * greatest);
    }
}
