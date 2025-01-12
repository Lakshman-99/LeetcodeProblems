import java.util.HashMap;

public class Largest_Subarray_With_0_Sum {
    public static int maxLen(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;

        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            if(sum == k)
                ans = Math.max(ans, i+1);

            if(map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-31, -48, -90, 54, 20, 95, 6, -86, 22};
        System.out.println(maxLen(arr, 0));
    }
}
