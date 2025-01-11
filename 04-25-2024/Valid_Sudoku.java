//  36. Valid Sudoku
//
//  https://leetcode.com/problems/valid-sudoku/description/

public class Valid_Sudoku {
    public static boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                char c = board[i][j];
                if(c == '.') continue;

                for(int k=0;k<9;k++) {
                    if(j != k && board[i][k] == c) return false;
                    if(i != k && board[k][j] == c) return false;
                }

                int p = 3*(i/3);
                int q = 3*(j/3);

                for(int k=p;k<p+3;k++) {
                    for(int l=q;l<q+3;l++) {
                        if(k!=i && l!=j && board[k][l] == c) return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
