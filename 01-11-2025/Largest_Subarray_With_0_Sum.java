import java.util.HashMap;

public class Largest_Subarray_With_0_Sum {
    public static int maxLen(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, i = 0, ans = 0;

        for(int num : arr) {
            sum += num;
            if(map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }

            map.put(sum, i++);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr, 0));
    }
}
