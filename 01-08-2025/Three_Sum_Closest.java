// 16. 3Sum Closest

// https://leetcode.com/problems/3sum-closest/description

import java.util.Arrays;

public class Three_Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, ans = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++) {
            int left = i+1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    ans = sum;
                }

                if(sum > target)
                    right--;
                else
                    left++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(arr, 1));
    }
}
