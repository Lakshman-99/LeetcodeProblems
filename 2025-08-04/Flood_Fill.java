package patterns.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});

        int pixelChange = image[sr][sc];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!queue.isEmpty()) {
            int[] pixelNode = queue.poll();
            image[pixelNode[0]][pixelNode[1]] = color;

            for(int[] dir : dirs) {
                int a = pixelNode[0] + dir[0];
                int b = pixelNode[1] + dir[1];

                if(a < 0 || b < 0 || a >= image.length || b >= image[0].length || image[a][b] != pixelChange)
                    continue;

                queue.add(new int[]{a,b});
            }
        }

        return image;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(arr, 1, 1, 2)));
    }
}
