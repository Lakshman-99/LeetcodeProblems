import java.util.Arrays;
import java.util.LinkedList;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] ans = new int[n][2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int ind = 0;
        for(int i=1;i<n;i++) {
            if(intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
            } else {
                ans[ind++] = intervals[i-1];
            }
        }
        ans[ind] = intervals[n-1];

        return Arrays.copyOfRange(ans, 0, ind+1);
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list  = new LinkedList<>();

        for(int[] interval : intervals) {
            if(list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            }
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4},{2,3}};
        int[][] ans = merge2(arr);
        for(int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
