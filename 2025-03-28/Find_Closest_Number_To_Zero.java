public class Find_Closest_Number_To_Zero {
    public static int findClosestNumber(int[] nums) {
        int diff = Integer.MAX_VALUE, ans = 0;
        for(int num : nums) {
            if(diff > Math.abs(num) || (diff == Math.abs(num) && ans < num)) {
                diff = Math.abs(num);
                ans = num;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, -1, 1};
        System.out.println(findClosestNumber(arr));
    }
}
