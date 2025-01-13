//  48. Rotate Image
//
//  https://leetcode.com/problems/rotate-image/description/
import java.util.Arrays;

public class Rotate_Image {
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int i, j, k;
        for(i=0;i<row;i++) {
            for(j=i+1;j<col;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(i=0;i<row;i++) {
            for(j=0, k=col-1;j<col/2;j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = new int[][] {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        rotate(mat);
        for(int[] r : mat)
            System.out.println(Arrays.toString(r));
    }

}
