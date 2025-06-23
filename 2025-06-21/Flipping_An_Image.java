package patterns.two_pointers;

import java.util.Arrays;

public class Flipping_An_Image {
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i=0;i<n;i++) {
            int left = 0;
            int right = n-1;
            while(left<=right) {
                int temp = image[i][left];
                image[i][left] = image[i][right] == 1 ? 0 : 1;
                image[i][right] = temp == 1 ? 0 : 1;
                left++;
                right--;
            }
        }

        return image;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(arr)));
    }
}
