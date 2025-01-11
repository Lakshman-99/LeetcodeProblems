// 229. Majority Element II

// https://leetcode.com/problems/majority-element-ii/description/

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int fst = 0, snd = 0, c1 = 0, c2 = 0;

        for(int num : nums) {
            if(num == fst)
                c1++;
            else if(num == snd)
                c2++;
            else if(c1 == 0) {
                fst = num;
                c1++;
            }
            else if(c2 == 0) {
                snd = num;
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for(int num : nums) {
            if(num == fst)
                c1++;
            else if(num == snd)
                c2++;
        }

        if(c1 > nums.length / 3)
            ans.add(fst);
        if(c2 > nums.length / 3)
            ans.add(snd);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,1};
        System.out.println(majorityElement(arr));
    }
}
