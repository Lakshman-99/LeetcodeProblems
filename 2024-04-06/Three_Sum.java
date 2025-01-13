//   15. 3Sum
//
//  https://leetcode.com/problems/3sum/description/
import java.util.*;

public class Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++) {
            int first = nums[i];
            int left = i+1;
            int right = n-1;
            while(left<right) {
                if(first + nums[left] + nums[right] == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(first, nums[left++], nums[right--])));
                }
                else if(first + nums[left] + nums[right] > 0) right--;
                else left++;
            }
        }
        return new ArrayList<>(ans);
    }
    public static void main(String[] args) {
        int[] num = new int[]{-2,0,1,1,2};
        List<List<Integer>> ans = threeSum(num);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
