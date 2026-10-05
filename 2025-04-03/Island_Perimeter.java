package amazon;

public class Island_Perimeter {
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0;i< grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0)
                    continue;

                for(int[] dir : dirs) {
                    int x = i+dir[0];
                    int y = j+dir[1];

                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == 0)
                        perimeter++;
                }
            }
        }

        return perimeter;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
