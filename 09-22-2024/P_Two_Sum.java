import java.util.Arrays;
import java.util.HashMap;

public class P_Two_Sum {
    public static int[] twoSum(int[] nums, int t) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if(hm.containsKey(t - nums[i])) {
                return new int[]{hm.get(t - nums[i]), i};
            } else {
                hm.put(nums[i], i);
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int t = 9;

        System.out.println(Arrays.toString(twoSum(nums, t)));
    }
}
