public class Search_in_rotated_array {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(nums[left] > nums[right]) {
            int mid = (left + right) / 2;

            if(nums[left] == target) {
                return left;
            }
            if(nums[left] >= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr = search(new int[]{4,5,6,7,0,1,2}, 0);

        System.out.print(arr + " ");
    }
}
