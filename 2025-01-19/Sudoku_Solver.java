package practice;

import java.util.Arrays;

public class Sudoku_Solver {
    public static boolean canFit(char[][] board, int row, int col, char c) {
        for(int i=0;i<9;i++)
            if((board[row][i] == c && i != col) || (board[i][col] == c && i != row))
                return false;

        int ri = (row/3) * 3;
        int rj = (col/3) * 3;

        for(int i=ri;i<ri+3;i++)
            for(int j=rj;j<rj+3;j++)
                if(board[i][j] == c)
                    return false;

        return true;
    }
    public static boolean solve(char[][] board, int row, int col) {
        if(row == 9) return true;
        if(col == 9) return solve(board, row+1, 0);

        if(board[row][col] != '.') return solve(board, row, col+1);

        for (char k='1'; k <= '9'; k++) {
            if (canFit(board, row, col, k)) {
                board[row][col] = k;
                if (solve(board, row, col + 1)) return true;

                board[row][col] = '.';
            }
        }

        return false;
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
