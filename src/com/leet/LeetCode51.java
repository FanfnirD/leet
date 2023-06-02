package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Fafnir
 * @date 2023/6/2
 */
public class LeetCode51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] checkerBoard = new char[n][n];
        for (char[] chars : checkerBoard) {
            Arrays.fill(chars, '.');
        }
        backTarting(0, checkerBoard);
        return res;
    }

    public void backTarting(int row, char[][] checkerBoard) {
        if (row == checkerBoard.length) {
            res.add(Array2List(checkerBoard));
            return;
        }
        for (int col = 0; col < checkerBoard.length; col++) {
            if (isValid(row, col, checkerBoard)) {
                checkerBoard[row][col] = 'Q';
                backTarting(row + 1, checkerBoard);
                checkerBoard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] checkerBoard) {

        // 同一列
        for (int i = 0; i < row; i++) {
            if (checkerBoard[i][col] == 'Q') {
                return false;
            }
        }

        // 左斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (checkerBoard[i][j] == 'Q') {
                return false;
            }
        }

        // 右斜线
        for (int i = row - 1, j = col + 1; i >= 0 && j < checkerBoard.length; i--, j++) {
            if (checkerBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> Array2List(char[][] checkerBoard) {
        if (checkerBoard == null) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        for (char[] chars : checkerBoard) {
            list.add(new String(chars));
        }
        return list;

    }
}
