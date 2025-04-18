import java.util.Arrays;

public class Maximum_Number_Of_Points_With_Cost {
    public static long solve(int row, int col, int[][] points, long[][] dp) {
        if(row < 0) return 0;

        if(dp[row][col] != -1)
            return dp[row][col];

        long ans = Integer.MIN_VALUE;
        for(int i=0;i<points[0].length;i++) {
            long value = points[row][i] - Math.abs(col - i) + solve(row-1, i, points, dp);
            ans = Math.max(ans, value);
        }

        return dp[row][col] = ans;
    }
    public static long maxPointsTD(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for(long[] row : dp)
            Arrays.fill(row, -1);

        long ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(ans, points[m-1][i] + solve(m-2, i, points, dp));

        return ans;
    }
    public static long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];

        for(int i=0;i<n;i++)
            dp[0][i] = points[0][i];

        for(int i=1;i<m;i++) {
            long[] left = new long[n];
            long[] right = new long[n];

            left[0] = dp[i-1][0];
            for(int j=1;j<n;j++)
                left[j] = Math.max(left[j-1]-1, dp[i-1][j]);

            right[n-1] = dp[i-1][n-1];
            for(int j=n-2;j>=0;j--)
                right[j] = Math.max(right[j+1]-1, dp[i-1][j]);

            for(int j=0;j<n;j++)
                dp[i][j] = points[i][j] + Math.max(left[j], right[j]);
        }

        long ans = Long.MIN_VALUE;
        for(int i=0;i<n;i++)
            ans = Math.max(ans, dp[m-1][i]);

        return ans;
    }
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {1, 5, 1},
                {3, 1, 1}
        };
        System.out.println(maxPoints(array));
    }
}
