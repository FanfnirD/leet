package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fafnir
 * @date 2023/6/26
 */
public class LeetCode1002 {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}).toString());
    }

    //public static List<String> commonChars(String[] words) {
    //    if (words == null || words.length <= 1) {
    //        return null;
    //    }
    //    int n = words.length;
    //    HashMap<Character, Integer> map = new HashMap<>();
    //    for (int i = 0; i < n; i++) {
    //        boolean[] visited = new boolean[26];
    //        String word = words[i];
    //        char[] str = word.toCharArray();
    //        for (char c : str) {
    //            if (!visited[c - 'a']) {
    //                map.put(c, map.getOrDefault(c, 0) + 1);
    //                visited[c - 'a'] = true;
    //            }
    //        }
    //
    //
    //    }
    //    ArrayList<String> res = new ArrayList<>();
    //    map.entrySet().forEach(entry -> {
    //        if (entry.getValue() == n) {
    //            res.add(entry.getKey().toString());
    //        }
    //    });
    //    return res;
    //}

    public static List<String> commonChars(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        int[] hash = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] hashOther = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                hashOther[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < hash.length; k++) {
                hash[k] = Math.min(hash[k], hashOther[k]);
            }

        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i]-- > 0) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;

    }
}
