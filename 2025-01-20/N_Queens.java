package practice;

import java.util.*;

public class N_Queens {
    public static List<List<String>> result;
    public static boolean canFit(char[][] board, int row, int col, int n) {
        for(int i=0;i<row;i++)
            if(board[i][col] == 'Q') return false;

        int xRow = row, xCol = col;
        while(xRow>=0 && xCol>=0)
            if(board[xRow--][xCol--] == 'Q') return false;

        xRow = row;
        xCol = col;
        while(xRow>=0 && xCol<n)
            if(board[xRow--][xCol++] == 'Q') return false;

        return true;
    }
    public static void solve(int ind, int n, char[][] board) {
        if(ind == n) {
            List<String> cur = new ArrayList<>();
            for(char[] c : board)
                cur.add(new String(c));

            result.add(cur);
            return;
        }

        for(int i=0;i<n;i++) {
            if(canFit(board, ind, i, n)) {
                board[ind][i] = 'Q';
                solve(ind+1, n, board);
                board[ind][i] = '.';
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] c : board)
            Arrays.fill(c, '.');

        solve(0, n, board);

        return result;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
