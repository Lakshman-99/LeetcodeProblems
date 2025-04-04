package amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class Rotting_Oranges {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1)
                    freshOranges++;

                if(grid[i][j] == 2)
                    queue.offer(new int[]{i,j});
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int ans = 0;
        while(!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            ans++;
            for(int i=0;i<size;i++) {
                int[] plot = queue.poll();
                int x = plot[0];
                int y = plot[1];
                for(int[] dir : dirs) {
                    int a = x + dir[0];
                    int b = y + dir[1];

                    if(a<0 || b<0 || a>=m || b>=n || grid[a][b] != 1) {
                        continue;
                    }

                    queue.offer(new int[]{a, b});
                    grid[a][b] = 2;
                    freshOranges--;
                }
            }
        }

        return freshOranges == 0 ? ans : -1;
    }
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }
}
