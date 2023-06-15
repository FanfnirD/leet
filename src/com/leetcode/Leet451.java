package com.leetcode;

import java.util.*;
import java.util.concurrent.TimeoutException;

/**
 * @author Fafnir
 * @date 2023/6/15
 */
public class Leet451 {
    public static void main(String[] args) {
        String tree = frequencySort("tree");
        System.out.println(tree);
    }
    public static String frequencySort(String s) {
        if (s == null) {
            return s;
        }
        char[] str = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] != b[1] ? b[1] - a[1] : a[0] - b[0];
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int k = cur[1];
            while (k-- > 0) {
                sb.append((char) (cur[0]));
            }
        }
        return sb.toString();
    }


}
