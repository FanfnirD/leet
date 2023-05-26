package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Fafnir
 * @date 2023/5/19
 */
public class Leet1337 {

    public static void main(String[] args) {
        int[][] ints = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};//[2,0,3,1,4]

        kWeakestRows(ints, 3);
    }

    static class Info {
        int r;
        int count;

        public Info(int r, int count) {
            this.r = r;
            this.count = count;
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        if (mat.length == 1) {
            return new int[]{0};
        }

        int index = 0;
        PriorityQueue<Info> list = new PriorityQueue<>((o1, o2) -> o1.count - o2.count != 0 ? o1.count - o2.count : o1.r - o2.r);
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][index] == 0) {
                while (index - 1 >= 0 && mat[i][index - 1] == 0) {
                    index--;
                }
                list.add(new Info(i, index));
            } else {
                while (index + 1 < mat[0].length && mat[i][index + 1] == 1) {
                    index++;
                }
                list.add(new Info(i, index + 1));
            }


        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.poll().r;
        }
        return res;
    }

}
