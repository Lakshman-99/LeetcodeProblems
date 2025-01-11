import java.util.*;
public class Triangle {
    public static int minPath(int row, int col, int n, List<List<Integer>> triangle, int[][] dp) {
        if(row == n) {
            return triangle.get(row).get(col);
        }
        if(dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int ind1 = minPath(row+1, col, n, triangle, dp);
        int ind2 = minPath(row+1, col+1, n, triangle, dp);

        return dp[row][col] = Math.min(ind1, ind2) + triangle.get(row).get(col);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row+1];
        for(int[] r : dp) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
//        return minPath(0, 0, row-1, triangle, dp);

        for(int i=0;i<row;i++) {
            dp[row-1][i] = triangle.get(row-1).get(i);
        }

        for(int i=row-2;i>=0;i--) {
            for(int j=i;j>=0;j--) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(-1));
        list.add(List.of(2,3));
        list.add(List.of(1,-1,-3));
        int ans = minimumTotal(list);
        System.out.println(ans);
    }
}
