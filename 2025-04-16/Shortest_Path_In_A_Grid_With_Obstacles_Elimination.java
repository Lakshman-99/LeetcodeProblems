import java.util.*;

public class Shortest_Path_In_A_Grid_With_Obstacles_Elimination {
    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length-1;
        int n = grid[0].length-1;
        if (k >= m + n) return m + n;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        boolean[][][] visited = new boolean[m+1][n+1][k+1];
        Deque<int[]> deque = new LinkedList<>();

        deque.offer(new int[]{0,0,k-grid[0][0],0});
        visited[0][0][k-grid[0][0]] = true;

        while(!deque.isEmpty()) {
            int[] node = deque.poll();
            int row = node[0];
            int col = node[1];
            int curK = node[2];
            int count = node[3];

            if(row==m && col==n)
                return count;

            for(int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];

                if(x<0 || y<0 || x>m || y>n || curK-grid[x][y] < 0 || visited[x][y][curK-grid[x][y]])
                    continue;

                visited[x][y][curK-grid[x][y]] = true;
                deque.offer(new int[]{x,y,curK-grid[x][y],count+1});
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        System.out.println(shortestPath(grid, 1));
    }
}
