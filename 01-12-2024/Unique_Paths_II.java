import java.util.*;
public class Unique_Paths_II {
    public static int uniq(int row, int col, int[][] grid, int[][] dp) {
        if(row == 0 && col == 0) {
            return grid[0][0] == 0 ? 1 : 0;
        }
        if(row<0 || col<0 || grid[row][col] == 1) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        return dp[row][col] = uniq(row-1, col, grid, dp) + uniq(row, col-1, grid, dp);
    }
    public static int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
//        int[][] dp = new int[row][col];
        // for(int[] r : dp) {
        //     Arrays.fill(r, -1);
        // }

        // return uniq(row-1, col-1, grid, dp);
//        for(int i=0;i<row;i++) {
//            for(int j=0;j<col;j++) {
//                if(i == 0 && j==0) {
//                    dp[0][0] = grid[0][0] == 0 ? 1 : 0;
//                }
//                else if(grid[i][j] == 1) {
//                    dp[i][j] = 0;
//                }
//                else {
//                    int left = 0, top = 0;
//                    if(i-1>=0) top = dp[i-1][j];
//                    if(j-1>=0) left = dp[i][j-1];
//                    dp[i][j] = top + left;
//                }
//            }
//        }
//        return dp[row-1][col-1];
        int[] prev = new int[col];
        Arrays.fill(prev, 0);
        for(int i=0;i<row;i++) {
            int[] cur = new int[col];
            for(int j=0;j<col;j++) {
                if(i == 0 && j==0) {
                    cur[0] = grid[0][0] == 0 ? 1 : 0;
                }
                else if(grid[i][j] == 1) {
                    cur[j] = 0;
                }
                else {
                    cur[j] = prev[j] + (j-1>=0 ? cur[j-1] : 0);
                }
            }
            prev = cur;
        }
        return prev[col-1];
    }
    public static void main(String[] args) {
        int ans = uniquePathsWithObstacles(new int[][]{{1,0}});
        System.out.println(ans);
    }
}
