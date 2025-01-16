package practice;

public class Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, cur = 0;

        for(int num : nums) {
            cur = num == 1 ? cur + 1 : 0;
            ans = Math.max(ans, cur);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,0,1};
        System.out.print(findMaxConsecutiveOnes(arr));
    }
}
