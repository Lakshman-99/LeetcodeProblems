package amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class Number_Of_Islands {
    public static void dfs_helper(char[][] mat, int i, int j) {
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j] != '1') return;
        mat[i][j] = '0';
        dfs_helper(mat, i, j+1);
        dfs_helper(mat, i, j-1);
        dfs_helper(mat, i+1, j);
        dfs_helper(mat, i-1, j);
    }
    public static int dfs(char[][] mat) {
        if(mat == null || mat.length == 0)
            return 0;

        int islands = 0, m = mat.length, n = mat[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == '1') {
                    islands++;
                    dfs_helper(mat, i, j);
                }
            }
        }
        return islands;
    }
    public static int bfs(char[][] mat) {
        if(mat == null || mat.length == 0)
            return 0;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new ArrayDeque<>();
        int islands = 0, m = mat.length, n = mat[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] != '1')
                    continue;

                islands++;
                q.offer(new int[]{i,j});
                while(!q.isEmpty()) {
                    int[] plots = q.poll();
                    int x = plots[0];
                    int y = plots[1];

                    for(int[] dir : directions) {
                        int a = x + dir[0];
                        int b = y + dir[1];

                        if(a<0 || b<0 || a>=m || b>=n || mat[a][b] != '1')
                            continue;

                        mat[a][b] = '0';
                        q.offer(new int[]{a,b});
                    }
                }
            }
        }

        return islands;
    }
    public static void main(String[] args) {
        char[][] mat = new char[][] {
                {'0','1','0','0'},
                {'1','1','1','0'},
                {'0','0','1','0'},
                {'1','1','1','0'}
        };

        System.out.println(dfs(mat));
    }
}
