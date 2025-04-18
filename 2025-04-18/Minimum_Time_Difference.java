import java.util.*;

public class Minimum_Time_Difference {
    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] diff = new int[n];

        for(int i=0;i<n;i++) {
            String point = timePoints.get(i);
            int time = 0;
            for(char c : point.toCharArray()) {
                if(c == ':') continue;
                time = time*10 + (c-'0');
            }
            diff[i] = 2400 - time;
        }

        Arrays.sort(diff);
        int minDiff = 2400;


        return 0;
    }
    public static void main(String[] args) {
        List<String> times = Arrays.asList("00:00","22:59","00:00","02:00","22:58");
        System.out.println(findMinDifference(times));
    }
}
