//  2997. Minimum Number of Operations to Make Array XOR Equal to K
//
//  https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k

public class Minimum_Number_Of_Operations_To_Make_Array_XOR_Equal_To_K {
    public static int minOperations(int[] nums, int k) {
        int totalXor = 0 ;
        for(int i : nums){
            totalXor ^= i;
        }
        int diff = totalXor^k;

        return Integer.bitCount(diff);
    }

    public static void main(String[] args) {
        int ans = minOperations(new int[]{2,1,3,4}, 1);
        System.out.println(ans);
    }
}
