import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Maximum_Number_Of_Fish_In_A_Grid {
    public static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int bfs(int row, int col, int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        int answer = 0;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            answer += grid[node[0]][node[1]];
            grid[node[0]][node[1]] = 0;

            for(int[] dir : DIRS) {
                int a = dir[0] + node[0];
                int b = dir[1] + node[1];

                if(a<0 || b<0 || a>=grid.length || b>=grid[0].length || grid[a][b]==0) continue;
                queue.add(new int[]{a,b});
            }
        }
        return answer;
    }
    public static int findMaxFish(int[][] grid) {
        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] > 0) {
                    answer = Math.max(answer, bfs(i,j,grid));
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] array = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        System.out.println(findMaxFish(array));
    }
}
