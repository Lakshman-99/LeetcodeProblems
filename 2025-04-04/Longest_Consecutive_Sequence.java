package amazon;

import java.util.*;

public class Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        int result = 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        for(int num : nums) {
            if(set.remove(num)) {
                int cur = 1, n = num;

                while(set.remove(n-1))
                    n--;

                cur += num-n;
                n=num;

                while(set.remove(n+1))
                    n++;

                cur += n-num;
                result = Math.max(result, cur);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }
}
