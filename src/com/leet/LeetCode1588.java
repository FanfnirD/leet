package com.leet;


/**
 * @author Fafnir
 * @date 2023/5/26
 */
public class LeetCode1588 {
    public static void main(String[] args) {
        LeetCode1588 leet = new LeetCode1588();
        int i = leet.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3});
        System.out.println(i);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int ans = 0;
        for (int len = 1; len <= n; len += 2) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                ans += sum[r + 1] - sum[l];
            }
        }
        return ans;

    }


    //public void backTranting(int[] arr, int startIndex, LinkedList<Integer> path) {
    //    if (startIndex >= arr.length) {
    //        return;
    //    }
    //    if (path.size() % 2 != 0) {
    //        for (Integer integer : path) {
    //            res += integer;
    //        }
    //    }
    //    for (int i = startIndex; i < arr.length; i++) {
    //
    //        path.add(arr[i]);
    //
    //        backTranting(arr, i + 1, path);
    //        path.removeLast();
    //    }
    //}
}
