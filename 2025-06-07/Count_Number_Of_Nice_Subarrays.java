package patterns.sliding_window;

public class Count_Number_Of_Nice_Subarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int answer = 0, left = 0, count = 0;
        for(int right=0;right<nums.length;right++) {
            count = nums[right]%2==1?count+1:count;
            while(count>k) {
                count = nums[left++]%2==1?count-1:count;
            }

            answer += right-left+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(arr, 2)-numberOfSubarrays(arr, 1));
    }
}
