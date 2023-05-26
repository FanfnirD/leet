package com.leet;

/**
 * @author Fafnir
 * @date 2023/5/24
 */
public class LeetCode152 {

    public static void main(String[] args) {
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        } else if(n == 1) {
            return nums[0];
        }
        int p = nums[0];
        int maxP = nums[0];
        int minP = nums[0];
        for(int i = 1; i < n; i++) {
            int t = maxP;
            maxP = Math.max(Math.max(maxP * nums[i], nums[i]), minP *nums[i]);
            minP = Math.min(Math.min(t * nums[i], nums[i]), minP * nums[i]);
            p = Math.max(maxP, p);
        }
        return p;
    }
}
