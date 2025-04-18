import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Swim_In_Rising_Water {
    public static int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(k -> k[2]));
        queue.offer(new int[]{0,0,grid[0][0]});
        int maxElevation = 0;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int a = node[0];
            int b = node[1];
            int curElevation = node[2];
            maxElevation = Integer.max(maxElevation, curElevation);

            if(a == m-1 && b == n-1)
                return maxElevation;

            if(visited[a][b]) continue;
            visited[a][b] = true;

            for(int[] dir : dirs) {
                int x = a + dir[0];
                int y = b + dir[1];

                if(x<0 || y<0 || x>=m || y>=n || visited[x][y])
                    continue;

                queue.offer(new int[]{x,y,grid[x][y]});
            }
        }

        return maxElevation;
    }
    public static void main(String[] args) {
        int[][] array = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        //System.out.println(swimInWater(array));

        int[][] grid1 = {{0, 2}, {1, 3}};
        System.out.println(swimInWater(grid1));
    }
}
