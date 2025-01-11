package practice;

public class Search_A_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0, j = n*m-1;

        while(i < j) {
            int mid = (i + j) / 2;

            int x = mid / m, y = mid % m;
            if(matrix[x][y] == target) return true;

            if(matrix[x][y] > target)
                j = mid;
            else
                i = mid + 1;
        }

        return matrix[i / m][i % m] == target;
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1}};
        System.out.println(searchMatrix(arr, 2));
    }
}
