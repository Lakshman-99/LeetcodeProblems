package amazon;

import java.util.Arrays;
import java.util.*;

public class Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            int str = i+1;
            int end = nums.length-1;

            while(str < end) {
                int sum = nums[i] + nums[str] + nums[end];

                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[str], nums[end]));
                    while(str<end && nums[str] == nums[str+1]) str++;
                    while(str<end && nums[end] == nums[end-1]) end--;
                    str++;
                    end--;
                }
                else if(sum > 0) {
                    end--;
                }
                else {
                    str++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
