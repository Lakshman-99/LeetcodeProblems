import java.util.*;

public class Minimum_Time_Difference {
    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] diff = new int[n];

        for(int i=0;i<n;i++) {
            String point = timePoints.get(i);
            int time = Integer.parseInt(point.substring(0,2))*60 + Integer.parseInt(point.substring(3));
            diff[i] = time;
        }
        Arrays.sort(diff);

        int minDiff = 2400;
        for(int i=1;i<n;i++) {
            minDiff = Math.min(minDiff, diff[i]-diff[i-1]);
        }

        return Math.min(minDiff, 24*60 - diff[n-1] + diff[0]);
    }
    public static void main(String[] args) {
        List<String> times = Arrays.asList("00:00","23:59");
        System.out.println(findMinDifference(times));
    }
}
