public class Search_In_Rotated_Sorted_Array_II {
    public static boolean search(int[] nums, int target) {
        int ind = 0;

        for(int i=1;i<nums.length;i++) {
            if(nums[i-1] > nums[i]) {
                ind = i;
                break;
            }
        }

        int mid, start, end = nums.length-1;

//        if(nums[ind] > target)
//            mid =
//
//        while()

        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,6,0,0,1,2};
        System.out.println(search(arr, 0));
    }
}
