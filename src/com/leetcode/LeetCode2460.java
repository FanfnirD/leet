package com.leetcode;

/**
 * @author fafnirH
 * @date 2023/4/4
 */
public class LeetCode2460 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 0};

        LeetCode2460 leetCode2460 = new LeetCode2460();
        leetCode2460.applyOperations(nums);
    }

    public int[] applyOperations(int[] nums) {

        if (nums == null || nums.length < 2) return nums;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) continue;
            else {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    nums[j + 1] = 0;
                    nums[j] *= 2;
                }
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
        return nums;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
