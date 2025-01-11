import java.util.*;

public class Remove_Duplicate {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if(nums[ind] < 0) {
                ans.add(ind + 1);
            }
            else {
                nums[ind] = -nums[ind];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> ans = findDuplicates(new int[]{4,3,2,7,8,2,3,1});

        System.out.println(ans);
    }
}
