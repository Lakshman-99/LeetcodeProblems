//  79. Word Search
//
//  https://leetcode.com/problems/word-search/description

public class Word_Search {
    public static boolean isValid(char[][] board, String word, int i, int j, int ptr) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(ptr)){
            return false;
        }
        if(ptr == word.length()-1) {
            return true;
        }
        char letter = board[i][j];
        board[i][j]='/';
        boolean ans = isValid(board, word, i+1, j, ptr+1) || isValid(board, word, i-1, j, ptr+1)
                || isValid(board, word, i, j+1, ptr+1) || isValid(board, word, i, j-1, ptr+1);

        board[i][j] = letter;
        return ans;
    }
    public static boolean exist(char[][] board, String word) {
        int ptr = 0;
        int m = board[0].length;
        int n = board.length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(isValid(board, word, i, j, ptr)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean ans = exist(arr, "ABCCED");
        System.out.println(ans);
    }
}
