package amazon;

import java.util.PriorityQueue;

public class Furthest_Building_You_Can_Reach {
    public static int solve(int[] heights, int cur, int bricks, int ladders) {
        if(cur+1 == heights.length) return 0;

        int ans;
        if(heights[cur] >= heights[cur+1]) {
            ans = solve(heights, cur+1, bricks, ladders);
        }
        else {
            int bri = -1;
            if(bricks >= heights[cur+1]-heights[cur]) {
                bri = solve(heights, cur+1, bricks-(heights[cur+1]-heights[cur]), ladders);
            }
            int lad = -1;
            if(ladders > 0) {
                lad = solve(heights, cur+1, bricks, ladders-1);
            }
            ans = Math.max(bri, lad);
        }

        return 1 + ans;
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int i=0;i<heights.length-1;i++) {
            if(heights[i] >= heights[i+1])
                continue;

            int diff = heights[i+1] - heights[i];
            bricks -= diff;
            queue.offer(diff);

            if(bricks < 0) {
                if(ladders == 0)
                    return i;

                ladders--;
                bricks += queue.poll();
            }
        }

        return heights.length-1;
    }
    public static void main(String[] args) {
        int[] h = {4,12,2,7,3,18,20,3,19};
        System.out.println(furthestBuilding(h, 10, 2));
    }
}
