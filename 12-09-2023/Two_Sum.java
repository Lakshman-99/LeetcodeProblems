import java.util.*;

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(hs.containsKey(target - nums[i])) {
                return new int[]{hs.get(target - nums[i]), i};
            }
            hs.put(nums[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{3,2,4}, 6);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
