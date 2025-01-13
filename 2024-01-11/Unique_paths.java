import java.util.*;
public class Unique_paths {
    public static int uniq(int row, int col, int[][] dp) {
        if(row == 0 && col == 0) {
            return 1;
        }
        if(row < 0 || col < 0) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        return dp[row][col] = uniq(row-1, col, dp) + uniq(row, col-1, dp);
    }
    public static int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for(int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//        return uniq(m-1, n-1, dp);
//        for(int row = 0; row<m; row++) {
//            for(int col=0; col<n; col++) {
//                if(row == 0 && col == 0) {
//                    dp[0][0] = 1;
//                }
//                else {
//                    int up = 0, left = 0;
//                    if(row - 1 >= 0) {
//                        up = dp[row - 1][col];
//                    }
//                    if(col - 1 >= 0) {
//                        left = dp[row][col - 1];
//                    }
//                    dp[row][col] = up + left;
//                }
//            }
//        }
//        return dp[m-1][n-1];
        int[] prev = new int[n];
        Arrays.fill(prev, 0);
        for(int row=0; row<m; row++) {
            int[] cur = new int[n];
            for(int col=0; col<n; col++) {
                if(row == 0 && col == 0) {
                    cur[col] = 1;
                }
                else {
                    cur[col] = prev[col] + (col - 1 >= 0 ?  cur[col - 1] : 0);
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
    public static void main(String[] args) {
        int ans = uniquePaths(3, 7);
        System.out.println(ans);
    }
}
