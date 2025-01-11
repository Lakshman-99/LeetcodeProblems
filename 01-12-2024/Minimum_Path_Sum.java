import java.util.*;
public class Minimum_Path_Sum {
    public static int minSum(int row, int col, int[][] grid, int[][] dp) {
        if(row == 0 && col == 0) {
            return grid[0][0];
        }
        if(row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int left = minSum(row, col-1, grid, dp);
        int top = minSum(row-1, col, grid, dp);
        return dp[row][col] = Math.min(left, top) + grid[row][col];
    }
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
//        int[][] dp = new int[row][col];
//
//        for(int[] r : dp) {
//            Arrays.fill(r, Integer.MAX_VALUE);
//        }
//        return minSum(row-1, col-1, grid, dp);

//        for(int i=0;i<row;i++) {
//            for(int j=0;j<col;j++) {
//                if(i == 0 && j == 0) {
//                    dp[0][0] = grid[0][0];
//                }
//                else {
//                    int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
//                    if(j-1 >= 0) left = dp[i][j-1];
//                    if(i-1 >= 0) top = dp[i-1][j];
//                    dp[i][j] = Math.min(left, top) + grid[i][j];
//                }
//            }
//        }
//        return dp[row-1][col-1];
        int[] prev = new int[col];
        Arrays.fill(prev, Integer.MAX_VALUE);

        for(int i=0;i<row;i++) {
            int[] cur = new int[col];
            for(int j=0;j<col;j++) {
                if(i==0 && j==0) {
                    cur[j]=grid[0][0];
                }
                else{
                    cur[j] = Math.min(prev[j], j-1>=0 ? cur[j-1] : Integer.MAX_VALUE) + grid[i][j];
                }
            }
            prev = cur;
        }
        return prev[col-1];
    }
    public static void main(String[] args) {
        int ans = minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        System.out.println(ans);
    }
}
