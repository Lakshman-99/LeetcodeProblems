public class Battleships_In_A_Board {
    public static int countBattleships(char[][] board) {
        int sum = 0;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'X' && (i==0 || board[i-1][j] == '.') && (j==0 || board[i][j-1] == '.'))
                    sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        System.out.println(countBattleships(grid));
    }
}
