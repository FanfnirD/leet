package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/11
 */
public class offer53 {
    public int missingNumber(int[] nums) {
        if(nums[0] == 1){
            return 0;
        }
        int mid = nums.length/2;
        int left = 0, right = nums.length-1;
        while((right - left) > 1){
            if(nums[mid] == mid){
                left = mid;
            }
            else{
                right = mid;
            }
            mid = (left + right)/2;
        }
        if(nums[left] + 1 == nums[right]){
            return nums[right] + 1;
        }
        else{
            return nums[left] + 1;
        }
    }
}
