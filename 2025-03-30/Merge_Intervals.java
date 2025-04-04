package amazon;

import java.util.*;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> intervalList = new ArrayList<>();
        int[] prev = intervals[0];

        for(int i=1;i<intervals.length;i++) {
            int[] cur = intervals[i];
            if(prev[1] >= cur[0]) {
                prev[1] = Math.max(prev[1], cur[1]);
            }
            else {
                intervalList.add(prev);
                prev = cur;
            }
        }
        intervalList.add(prev);

        return intervalList.toArray(new int[intervalList.size()][]);
    }
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }
}
