//  136. Single Number
//
//  https://leetcode.com/problems/single-number/description/

public class Single_Number {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            ans ^= num;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,1,2,2,1,2};
        int ans = singleNumber(arr);
        System.out.println(ans);
    }
}
