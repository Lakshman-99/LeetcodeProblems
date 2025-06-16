package patterns.two_pointers;

import java.util.*;

public class Four_Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        Arrays.sort(nums);
        int n = nums.length;
        int avg = target/4;
        if(nums[0] > avg || nums[n-1] < avg) return result;

        for(int i=0;i<n-3;i++) {
            if(i>0 && nums[i-1] == nums[i]) continue;

            for(int j=i+1;j<n-2;j++) {
                if(j>i+1 && nums[j-1] == nums[j]) continue;

                int left = j+1;
                int right = n-1;

                while(left < right) {
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];

                    if(sum == target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left] == nums[left-1]) left++;
                        while(left<right && nums[right] == nums[right+1]) right--;
                    }
                    else if(sum < target) left++;
                    else right--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        System.out.println(fourSum(arr, 8));
    }
}
