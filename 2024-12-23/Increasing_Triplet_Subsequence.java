// 334. Increasing Triplet Subsequence

// https://leetcode.com/problems/increasing-triplet-subsequence/description

public class Increasing_Triplet_Subsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for (int third : nums) {
            if (third > second) {
                return true;
            } else if (third > first) {
                second = third;
            } else {
                first = third;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{4,5,2147483647,1,2};
        System.out.println(increasingTriplet(arr1));
    }
}
