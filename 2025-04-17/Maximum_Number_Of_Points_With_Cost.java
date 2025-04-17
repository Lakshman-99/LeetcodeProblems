import java.util.Arrays;

public class Maximum_Number_Of_Points_With_Cost {
    public static int solve(int row, int col, int[][] points, int[][] dp) {
        if(points[][)
    }
    public static long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(m-1, n-1, points, dp);
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
