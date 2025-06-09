package patterns.sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class Shortest_Subarray_With_Sum_At_Least_K {
    public static int shortestSubarray(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        long[] prefix = new long[nums.length + 1];
        for(int i=0;i<nums.length;i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }

        int answer = Integer.MAX_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        for(int right=0;right<nums.length+1;right++) {
            while(!dq.isEmpty() && prefix[right] - prefix[dq.peekFirst()] >= k) {
                answer = Math.min(answer, right - dq.pollFirst());
            }
            while(!dq.isEmpty() && prefix[right] <= prefix[dq.getLast()]) {
                dq.pollLast();
            }
            dq.addLast(right);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void main(String[] args) {
        int[] arr = {-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6};
        System.out.println(shortestSubarray(arr, 151));
    }
}
