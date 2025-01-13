package practice;

import java.util.Arrays;

public class Unique_Paths {
    public static int solve(int[][] dp, int row, int col) {
        if(row == 0 && col == 0) {
            return 1;
        }
        if(row < 0 || col < 0) {
            return 0;
        }
        if(dp[row][col] != -1)
            return dp[row][col];

        return dp[row][col] = solve(dp, row-1, col) + solve(dp, row, col-1);
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(dp, m-1, n-1);
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
