//  485. Max Consecutive Ones
//
//  https://leetcode.com/problems/max-consecutive-ones/description/
public class Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, count = 0;
        for(int num : nums) {
            if(num == 1) count++;
            else count = 0;
            if(ans<count) ans = count;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,1,1,1};
        System.out.print(findMaxConsecutiveOnes(arr));
    }
}
