package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fafnirH
 * @date 2023/4/28
 */
public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        Set<Integer> map = new HashSet<>();

        for (int num : nums) {
            if (map.contains(num)){
                return true;
            }else {
                map.add(num);
            }
        }
        return false;
    }
}
