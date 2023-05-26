package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fafnir
 * @date 2023/5/17
 */
public class LeetCodeII079 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        backTracking(nums,0,res,temp);
        return res;
    }
    public void backTracking(int[] nums,int startIndex,List<List<Integer>> res,List<Integer> temp){


    }
}
