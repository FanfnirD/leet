package com.leet;

/**
 * @author Fafnir
 * @date 2023/6/2
 */
public class Leet52 {
    public static void main(String[] args) {
        new Leet52().totalNQueens(4);
    }
    public int totalNQueens(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return NQueens(0, new int[n]);
    }

    public int NQueens(int n, int[] board) {
        if (n == board.length) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            if (isValid(n, i, board)) {
                board[n] = i;
                res += NQueens(n + 1, board);
            }
        }
        return res;

    }

    public boolean isValid(int row, int col, int[] board) {
        for (int k = 0; k < row && k < board.length; k++) {
            if (board[k] == col || Math.abs(board[k] - col) == Math.abs(k - row)) {
                return false;
            }
        }
        return true;
    }
}
