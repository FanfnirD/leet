package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fafnirH
 * @date 2023/4/27
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String[] abcs = permutation.permutation("abc");
    }

    public String[] permutation(String s) {

        if (s == null) {
            return null;
        }
        if (s.length() < 2) {
            result.add(s);
            return result.toArray(new String[]{});
        }
        recursion(s.toCharArray(), 0);
        String[] strArr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            strArr[i] = result.get(i);
        }
        return strArr;

    }

    List<String> result = new ArrayList<>();


    public void recursion(char[] chars, int index) {
        if (index == chars.length) {

            result.add(new String(chars));
            return;
        }
        boolean[] visited = new boolean[26];
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            if (!visited[chars[index] - 'a']) {
                visited[chars[index] - 'a'] = true;
                recursion(chars, index + 1);
            }
            swap(chars, index, i);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
