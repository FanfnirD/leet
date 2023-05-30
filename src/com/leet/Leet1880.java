package com.leet;

/**
 * @author Fafnir
 * @date 2023/5/30
 */
public class Leet1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = firstWord.length();
        int b = secondWord.length();
        int c = targetWord.length();
        int sum1 = 0;
        int sum2 = 0;
        int sum0 = 0;
        for (int i = 0; i < a; i++) {
            sum1 = sum1 * 10 + firstWord.charAt(i) - 'a';
        }
        for (int i = 0; i < b; i++) {
            sum2 = sum2 * 10 + secondWord.charAt(i) - 'a';
        }
        for (int i = 0; i < c; i++) {
            sum0 = sum0 * 10 + targetWord.charAt(i) - 'a';
        }
        return sum1 + sum2 == sum0;
    }
}
