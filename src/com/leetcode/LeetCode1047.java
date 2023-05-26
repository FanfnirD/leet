package com.leetcode;

import java.util.Stack;

public class LeetCode1047 {


    public static void main(String[] args) {
        String s = "abbaca";
        LeetCode1047 leetCode1047 = new LeetCode1047();
        String s1 = leetCode1047.removeDuplicates(s);
        System.out.println(s1);
    }

    public String removeDuplicates(String s) {

        if (s == null || s.length() < 1) {
            return null;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && chars[i] == stack.peek()) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        char[] resultChar = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            resultChar[i--] = stack.pop();
        }
        return new String(resultChar);
    }

    class Solution {

        public String removeDuplicates(String s) {
            /**
             可以尝试双指针，代替栈来提高效率
             但发现实现起来更麻烦，所以最后还是得采用栈的方式进行才行
             其实双指针是可以，不过我最后思考的有点偏差，我是当遇到不匹配的元素设为一个无用的标识
             但这样的话，就会出现慢指针回退，还得来个判断直到有效的位置
             应该是慢指针之前的区域都是有效的区域，所以当遇到有不相等的元素时，应该是将有效的元素替换到慢指针+1的位置
             */
            if(null == s){
                return "";
            }
            char[] arr = s.toCharArray();
            int slow = -1;
            for(int i = 0 ; i < arr.length; i++){
                if(-1 == slow || arr[slow] != arr[i]){
                    arr[++slow] = arr[i];
                }else{
                    slow--;// 回退
                }
            }
            return new String(arr).substring(0, slow + 1);
        }


    }
}
