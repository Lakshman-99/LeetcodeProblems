package practice;

import java.util.Arrays;

public class Rotate_Image {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

            int s=0, e=n-1;
            while(s<e) {
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
                s++;
                e--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(arr);
        for(int[] a : arr)
            System.out.println(Arrays.toString(a));
    }
}
