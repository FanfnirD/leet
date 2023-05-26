package com.leetcode;

import java.util.Stack;

public class LeetCode150 {
    public static void main(String[] args) {
        String[] strs = {"4", "13", "5", "/", "+"};
        LeetCode150 leetCode150 = new LeetCode150();
        System.out.println(leetCode150.evalRPN(strs));
    }


    public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("/") || tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-")) {

                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (tokens[i]) {
                    case "/":
                        result = num2 / num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                }
                stack.push(result);
            } else if (Integer.valueOf(tokens[i]) >= -200 || Integer.valueOf(tokens[i]) <= 200) {
                stack.push(Integer.valueOf(tokens[i]));
            }

        }
        return stack.pop();
    }
}
