// 228. Summary Ranges

// https://leetcode.com/problems/summary-ranges/description

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if(nums.length == 0) return ans;

        int prev = nums[0], c = 1, i;

        for(i=1;i<nums.length;i++) {
            if(Math.abs(nums[i-1] - nums[i]) != 1) {
                if(c == 1)
                    ans.add(prev + "");
                else
                    ans.add(prev + "->" + nums[i-1]);

                prev = nums[i];
                c = 1;
                continue;
            }
            c++;
        }

        if(c == 1)
            ans.add(prev + "");
        else
            ans.add(prev + "->" + nums[i-1]);

        return ans;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n;i++) {
            int st = nums[i];
            while(i+1 < n && nums[i+1]-nums[i] == 1) i++;
            ans.add(st == nums[i] ? st+"" : st+"->"+nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges2(arr));
    }
}
