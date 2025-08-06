package patterns.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Surrounded_Regions {
    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'V';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
    public static void processBoard(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()) {
            int[] region = queue.poll();

            for(int[] dir : dirs) {
                int a = region[0] + dir[0];
                int b = region[1] + dir[1];

                if(a<0 || b<0 || a>=board.length || b>=board[0].length || board[a][b] != 'O')
                    continue;

                queue.add(new int[]{a, b});
            }

            board[region[0]][region[1]] = 'V';
        }
    }
    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n-1] == 'O') dfs(board, i, n-1);
        }

        for(int i=0;i<n;i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[m-1][i] == 'O') dfs(board, m-1, i);
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'V')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(Arrays.deepToString(arr));
        solve(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
