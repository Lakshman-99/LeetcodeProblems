public class Search_Index_Position {
    public static int searchInsert(int[] nums, int target) {
        int i = 0, j=nums.length;
        while(i<=j) {
            int m = (i + j)/2;
            if(nums[m] == target) {
                return m;
            }
            if(target > nums[m]) {
                i = m+1;
            }
            else {
                j = m-1;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(arr, target));
    }
}
