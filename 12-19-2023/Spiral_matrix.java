import java.util.*;
public class Spiral_matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int st_row = 0, end_col = 0;

        while(true) {
            for(int i=end_col; i<col;i++) {
                ans.add(matrix[st_row][i]);
            }
            st_row++;

            if (st_row >= row || end_col >= col) {
                break;
            }

            for(int i=st_row; i<row; i++) {
                ans.add(matrix[i][col-1]);
            }
            col--;

            if(end_col > col) {
                break;
            }

            for(int i=col-1;i>=end_col;i--) {
                ans.add(matrix[row-1][i]);
            }
            row--;

            if (st_row >= row || end_col >= col) {
                break;
            }

            for(int i=row-1;i>=st_row;i--) {
                ans.add(matrix[i][end_col]);
            }
            end_col++;

            if(end_col > col) {
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> arr = spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});

        System.out.print(arr + " ");
    }
}
