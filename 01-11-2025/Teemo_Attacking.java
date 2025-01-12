// 495. Teemo Attacking

// https://leetcode.com/problems/teemo-attacking/description

public class Teemo_Attacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;

        for (int i = 0; i < timeSeries.length - 1; i++){
            ans += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);

        }

        return ans+duration;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(findPoisonedDuration(arr, 1));
    }
}
