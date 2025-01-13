//  1289. Minimum Falling Path Sum II
//
//  https://leetcode.com/problems/minimum-falling-path-sum-ii/description

import java.util.Arrays;

public class Minimum_Falling_Path_Sum_II {

    public static int solve(int[][] grid, int[][] dp, int n, int m, int row, int col) {
        if(col < 0 || row > n || col >= m) return Integer.MAX_VALUE;
        if(row == n-1) {
            return grid[row][col];
        }
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int local = Integer.MAX_VALUE;
        for(int j=0;j<m;j++) {
            if(j != col)
                local = Math.min(local, solve(grid, dp, n, m, row+1, j));
        }
        dp[row][col] = local + grid[row][col];

        return dp[row][col];
    }
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int[] r : dp)
            Arrays.fill(r, Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++) {
            ans = Math.min(ans, solve(grid, dp, n, m, 0, i));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {-73,61,43,-48,-36},
                {3,  30,27,57,10},
                {96,-76,84,59,-15},
                {5,-49,76,31,-7},
                {97,91,61,-46,67}
        };
        System.out.println(minFallingPathSum(mat));
    }
}
