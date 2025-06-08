package patterns.sliding_window;

public class Shortest_Subarray_With_Sum_At_Least_K {
    public static int shortestSubarray(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] prefix = new int[nums.length];
        int total = 0;
        for(int i=0;i<nums.length;i++) {
            prefix[i] = total + nums[i];
            total = prefix[i];
        }

        int left = 0, sum = 0, answer = Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++) {
            sum += nums[right];
            while(sum >= k || (left < right && sum - nums[left] >= k)) {
                answer = Math.min(answer, right-left+1);
                sum -= nums[left++];
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void main(String[] args) {
        int[] arr = {-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6};
        System.out.println(shortestSubarray(arr, 151));
    }
}
