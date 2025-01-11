import java.util.*;

public class Four_Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++) {
            if(i>0 && nums[i] == nums[i-1])
                continue;

            for(int j=i+1;j<nums.length-2;j++) {
                int left = j + 1;
                int right = nums.length-1;

                while(left < right) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                    else if(sum > target)
                        right--;
                    else
                        left++;
                }
            }
        }

        return set;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,-1,0,-2,2};
        System.out.println(fourSum(arr, 0));
    }
}
