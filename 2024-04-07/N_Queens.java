//  51. N-Queens
//
//  https://leetcode.com/problems/n-queens/description/

import java.util.*;
public class N_Queens {
    public static List<List<String>> ans;
    public static boolean isSafe(boolean[][] queen, int row, int col, int n) {
        for(int i=0; i<row; i++) {
            if(queen[i][col]) return false;
        }

        int i = row; int j = col;
        while(i >= 0 && j >= 0) {
            if(queen[i][j]) return false;
            i--; j--;
        }

        i = row; j = col;
        while(i >= 0 && j < n) {
            if(queen[i][j]) return false;
            i--; j++;
        }
        return true;
    }
    public static void solve(boolean[][] queen, int row, int n) {
        if(row == n) {
            List<String> sub = new ArrayList<>();
            for(boolean[] r : queen) {
                StringBuilder str = new StringBuilder();
                for(boolean b : r) {
                    if(b) str.append("Q");
                    else str.append(".");
                }
                sub.add(str.toString());
            }
            ans.add(sub);
            return;
        }
        for(int i=0;i<n;i++) {
            if(isSafe(queen, row, i, n)) {
                queen[row][i] = true;
                solve(queen, row + 1, n);
                queen[row][i] = false;
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        boolean[][] queen = new boolean[n][n];
        solve(queen, 0, n);
        return ans;
    }
    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(1);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
