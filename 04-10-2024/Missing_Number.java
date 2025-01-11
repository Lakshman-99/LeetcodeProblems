//  268. Missing Number
//
//  https://leetcode.com/problems/missing-number/
public class Missing_Number {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * (n+1)) / 2;
        int total = 0;
        for(int num : nums) total+=num;
        return sum-total;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,0,1};
        System.out.print(missingNumber(arr));
    }
}
