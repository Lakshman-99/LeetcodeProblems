//  37. Sudoku Solver
//
//  https://leetcode.com/problems/sudoku-solver/description/

import java.util.*;

public class Sudoku_Solver {
    public static boolean isSafe(char[][] board, int row, int col, char num) {
        for(int i=0;i<9;i++) {
            if(board[row][i] == num && i!=col) return false;
            if(board[i][col] == num && i!=row) return false;
        }

        int lr = 3*(row/3);
        int lc = 3*(col/3);
        for(int i=lr;i<lr+3;i++){
            for(int j=lc;j<lc+3;j++){
                if(row!=i && col!=j && board[i][j] == num)  return false;
            }
        }

        return true;
    }
    public static boolean solve(char[][] board, int row, int col) {
        if(col == 9) {
            row++;
            col = 0;
        }
        if(row == 9) return true;

        if(board[row][col] == '.') {
            for(char j='1';j<='9';j++) {
                if(isSafe(board, row, col, j)) {
                    board[row][col] = j;
                    if(solve(board, row, col+1)) return true;
                    board[row][col] = '.';
                }
            }
            return false;
        }
        return solve(board, row, col+1);
    }
    public static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        for(char[] r : board)
            System.out.println(Arrays.toString(r));
    }
}
