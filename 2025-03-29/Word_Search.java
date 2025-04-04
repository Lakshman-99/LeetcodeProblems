package amazon;

public class Word_Search {
    public static boolean dfs(char[][] board, int i, int j, String word, int cur) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(cur))
            return false;

        if(cur == word.length()-1) return true;

        char ch = board[i][j];
        board[i][j] = '/';
        boolean a = dfs(board, i, j+1, word, cur+1);
        boolean b = dfs(board, i, j-1, word, cur+1);
        boolean c = dfs(board, i+1, j, word, cur+1);
        boolean d = dfs(board, i-1, j, word, cur+1);
        board[i][j] = ch;

        return a || b || c || d;
    }
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean ans = exist(arr, "ABCD");
        System.out.println(ans);
    }
}
