import java.util.*;
public class Minimum_operation_to_empty_array {
    public static int minOperations(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(int i : hm.values()) {
            if(i == 1) {
                return -1;
            }
            ans+=i/3;
            if(i%3!=0) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans= minOperations(new int[]{2,3,3,2,2,4,2,3,4});
        System.out.println(ans);
    }
}
