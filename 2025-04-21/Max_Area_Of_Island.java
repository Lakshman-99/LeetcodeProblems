public class Max_Area_Of_Island {
    public static int dfs(int row, int col, int[][] grid) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0) return 0;

        grid[row][col] = 0;
        return 1 + dfs(row,col+1, grid) + dfs(row, col-1, grid) + dfs(row+1,col,grid) + dfs(row-1,col,grid);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    answer = Math.max(answer, dfs(i,j,grid));
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(arr));
    }
}
