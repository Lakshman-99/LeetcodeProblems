package amazon;

public class Valid_Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                char check = board[i][j];
                if(check == '.') continue;

                for(int k=0;k<9;k++) {
                    if(j != k && board[i][k] == check) return false;
                    if(i != k && board[k][j] == check) return false;
                }

                int row = i/3 * 3;
                int col = j/3 * 3;

                for(int a=row;a<row+3;a++) {
                    for(int b=col;b<col+3;b++) {
                        if(a!=i && b!=j && board[a][b] == check)
                            return false;
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
