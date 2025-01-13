//  52. N-Queens II
//
//  https://leetcode.com/problems/n-queens-ii/description/

public class N_Queens_II {
    public static int ans;
    public static boolean isSafe(boolean[][] queen, int col, int row, int n) {
        for(int i=0;i<row;i++) {
            if(queen[i][col]) return false;
        }
        int r=row, c=col;
        while(r>=0 && c>=0) {
            if(queen[r--][c--]) return false;
        }
        r=row;
        c=col;
        while(r>=0 && c<n) {
            if(queen[r--][c++]) return false;
        }
        return true;
    }
    public static void solve(boolean[][] queen, int row, int n) {
        if(row == n) {
            ans++;
            return;
        }
        for(int i=0;i<n;i++) {
            if(isSafe(queen, i, row, n)) {
                queen[row][i] = true;
                solve(queen, row+1, n);
                queen[row][i] = false;
            }
        }
    }
    public static int totalNQueens(int n) {
        ans = 0;
        boolean[][] queen = new boolean[n][n];
        solve(queen, 0, n);
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(totalNQueens(1));
    }
}
