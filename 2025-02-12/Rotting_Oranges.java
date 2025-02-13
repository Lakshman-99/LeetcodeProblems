// 994. Rotting Oranges

// https://leetcode.com/problems/rotting-oranges/description/

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    public static int orangesRotting(int[][] grid) {
        int ans = -1;
        Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        int freshO = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    freshO++;
            }
        }

        if(freshO == 0) return 0;
        if(q.isEmpty()) return -1;

        int[][] moves = {{1, 0},{-1, 0},{0, -1},{0, 1}};

        while(!q.isEmpty()) {
            int s = q.size();
            while(s-- > 0) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];

                for(int[] move : moves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if(x<n && x>=0 && y<m && y>=0 && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshO--;
                        q.add(new int[]{x,y});
                    }
                }
            }
            ans++;
        }

        return freshO == 0 ? ans : -1;
    }
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }
}
