import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int ans = 1;

        for(int num : nums) {
            if(set.remove(num)) {
                int n = num, cons = 1;

                while(set.remove(n-1))
                    n--;

                cons += num - n;
                n = num;
                while(set.remove(n+1))
                    n++;

                cons += n - num;
                ans = Math.max(ans, cons);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
         int[] arr = new int[]{};
         System.out.println(longestConsecutive(arr));
    }
}
