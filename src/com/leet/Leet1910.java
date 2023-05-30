package com.leet;

/**
 * @author Fafnir
 * @date 2023/5/30
 */
public class Leet1910 {
    public static void main(String[] args) {
        String s = removeOccurrences("axxxxyyyyb", "xy");
        System.out.println(s);
    }

    public static String removeOccurrences(String s, String part) {
        if (s.length() == 0 || part.length() == 0) {
            return s;
        }
        int len = part.length();
        for (int i = 0; i <= s.length() - len; i++) {
            if (s.charAt(i) == part.charAt(0)) {
                if (s.substring(i, i + len).equals(part)) {
                    String now = s.substring(0, i) + s.substring(i + len);
                    return removeOccurrences(now, part);
                }
            }
        }
        return s;

    }


}
