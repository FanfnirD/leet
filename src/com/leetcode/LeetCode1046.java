package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author fafnirH
 * @date 2023/4/24
 */
public class LeetCode1046 {

    public int lastStoneWeight(int[] stones) {

        int n = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() >= 2) {
            Integer value1 = maxHeap.poll();
            Integer value2 = maxHeap.poll();
            if (value1.equals(value2)) {
                continue;
            }
            maxHeap.offer(value1 - value2);
        }
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.poll();

    }
}
