package com.leetcode;

import java.lang.ref.PhantomReference;

/**
 * @author Fafnir
 * @date 2023/6/26
 */
public class LeetCode848 {

    public String shiftingLetters(String s, int[] shifts) {
        char[] data = s.toCharArray();
        long shift = 0;
        for(int i=data.length-1;i>=0;i--){
            shift += shifts[i];
            data[i] = (char)('a' + (data[i]-'a'+shift) % 26);
        }
        return new String(data);
    }
}
