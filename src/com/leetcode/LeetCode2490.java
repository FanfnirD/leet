package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fafnirH
 * @date 2023/4/25
 */
public class LeetCode2490 {
    public boolean isCircularSentence(String sentence) {
        //if (sentence.length() == 1) {
        //    return true;
        //}
        //String[] works = sentence.split("\\s+");
        //if (works[0].charAt(0) != works[works.length - 1].charAt(works[works.length - 1].length() - 1)) {
        //    return false;
        //}
        //for (int i = 1; i < works.length; i++) {
        //    if (works[i].charAt(0) != works[i - 1].charAt(works[i - 1].length()-1)) {
        //        return false;
        //    }
        //}
        //return true;

        if(sentence==null||sentence.length()==0||sentence.charAt(0)!=sentence.charAt(sentence.length()-1)){
            return false;
        }
        char[] chars = sentence.toCharArray();
        int max = chars.length-1;
        for(int i = 1;i<max;i++){
            if(chars[i]!= ' '){
                continue;
            }
            if(chars[i-1]!=chars[i+1]){
                return false;
            }
        }
        return true;
    }

    public List<Integer> targetIndices(int[] nums, int target) {

        int lt =0;
        int eq=0;
        for(int num:nums){
            if(num < target){
                lt++;
            }else if(num == target){
                eq++;
            }
        }
        List list =  new ArrayList<Integer>();
        for(int i = 1; i <= eq;i++){
            list.add(lt+i);
        }
        return list;
    }

}
