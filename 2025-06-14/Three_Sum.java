package patterns.two_pointers;

import java.util.*;

public class Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            if(i>0 && nums[i-1] == nums[i]) continue;

            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while(left < right && nums[left] == nums[left-1]) left++;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
