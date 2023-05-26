package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/24
 */
public class LeetCode1389 {

    public static void main(String[] args) {
        int[] num1 = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] targetArray = createTargetArray(num1, index);
    }

    public static int[] createTargetArray(int[] nums, int[] index) {

        Integer.bitCount(nums[1]);
        if (nums.length <= 1) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            int insertIndex = index[i];

            int temp = nums[i];
            for (int j = i; j > insertIndex; j--) {
                nums[j] = nums[j - 1];
            }
            nums[insertIndex] = temp;
        }
        return nums;
    }
}
