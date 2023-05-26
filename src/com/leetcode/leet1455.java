package com.leetcode;

/**
 * @author Fafnir
 * @date 2023/5/22
 */
public class leet1455 {
    //sentence = "i love eating burger", searchWord = "burg"
    //输出：4
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("hello from the other side",
                "they"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null || searchWord == null || sentence.length() < searchWord.length()) {
            return -1;
        }

        String str = sentence + " ";
        int len1 = str.length();
        int len2 = searchWord.length();
        int searchIndex = 0;
        int left = 0;
        while (left < len1 && str.charAt(left) == ' ') {
            left++;
        }
        int index = 0;
        int right = left;
        while (right < len1 && searchIndex < len2) {
            if (str.charAt(right) != ' ') {
                right++;
                continue;
            } else {
                index++;
                while (left<=right && searchIndex < len2 ) {
                    if (str.charAt(left) == searchWord.charAt(searchIndex)) {
                        left++;
                        searchIndex++;
                    } else {
                        searchIndex = 0;
                        left = right + 1;
                        right++;
                        break;
                    }
                }
            }
        }
        return searchIndex == len2 ? index : -1;
    }


}
