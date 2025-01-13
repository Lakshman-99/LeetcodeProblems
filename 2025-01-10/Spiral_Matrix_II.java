// 59. Spiral Matrix II

// https://leetcode.com/problems/spiral-matrix-ii/description

import java.util.Arrays;

public class Spiral_Matrix_II {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = 0, c = 1;
        int start = 0, end = n-1, top = 0, bottom = n-1;

        while(x <= n/2) {
            for(int i=start;i<=end;i++) {
                ans[top][i] = c++;
            }

            for(int i=top+1;i<=bottom;i++) {
                ans[i][end] = c++;
            }

            for(int i=end-1;i>=start;i--) {
                ans[bottom][i] = c++;
            }

            for(int i=bottom-1;i>=start+1;i--) {
                ans[i][top] = c++;
            }

            x++;
            top++;
            start++;
            end--;
            bottom--;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = generateMatrix(20);

        for(int[] a : arr)
            System.out.println(Arrays.toString(a));
    }
}
