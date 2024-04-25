//  74. Search a 2D Matrix
//
//  https://leetcode.com/problems/search-a-2d-matrix/
public class Search_A_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int ind = -1;
        for(int i=0;i<n;i++) {
            if(matrix[i][m-1] == target) return true;
            else if(target < matrix[i][m-1]) {
                ind = i;
                break;
            }
        }

        if(ind == -1) return false;

        for(int j=0;j<m;j++) {
            if(matrix[ind][j] == target) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1}
        };
        System.out.println(searchMatrix(mat, 3));
    }
}
