package amazon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Flood_Fill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        int m = image.length;
        int n = image[0].length;
        int colorOrig = image[sr][sc];
        if(colorOrig == color) return image;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
            int[] plot = q.poll();
            int a = plot[0];
            int b = plot[1];

            for(int[] dir : dirs) {
                int x = a + dir[0];
                int y = b + dir[1];

                if(x<0 || y<0 || x>=m || y>=n || colorOrig != image[x][y])
                    continue;

                q.offer(new int[]{x,y});
            }
            image[a][b] = color;
        }

        return image;
    }
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(floodFill(arr, 0, 0, 0)));
    }
}
