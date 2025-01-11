import java.util.Arrays;

public class Set_Matrix_Zeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] != 0) continue;
                int x = i-1;
                int y = j-1;

                while(x>=0) {
                    if (matrix[x][j] != 0)
                        matrix[x][j] = 99;

                    x--;
                }

                while(y>=0) {
                    if (matrix[i][y] != 0)
                        matrix[i][y] = 99;

                    y--;
                }

                x = i+1;
                y = j+1;

                while(x<n) {
                    if (matrix[x][j] != 0)
                        matrix[x][j] = 99;

                    x++;
                }

                while(y<m) {
                    if (matrix[i][y] != 0)
                        matrix[i][y] = 99;

                    y++;
                }

                matrix[i][j] = 99;
            }
        }

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(matrix[i][j] == 99)
                    matrix[i][j] = 0;
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(arr);

        for(int[] a : arr)
            System.out.println(Arrays.toString(a));

    }
}
