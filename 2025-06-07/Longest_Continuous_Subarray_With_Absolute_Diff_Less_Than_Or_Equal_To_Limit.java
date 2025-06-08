package patterns.sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_Or_Equal_To_Limit {
    public static int longestSubarray(int[] nums, int limit) {
        int answer = 0, left = 0;
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();

        for(int right=0;right<nums.length;right++) {
            while(!maxQ.isEmpty() && maxQ.peekLast() < nums[right]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(nums[right]);

            while(!minQ.isEmpty() && minQ.peekLast() > nums[right]) {
                minQ.pollLast();
            }
            minQ.offerLast(nums[right]);

            while(maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if(maxQ.peekFirst() == nums[left])
                    maxQ.pollFirst();

                if(minQ.peekFirst() == nums[left])
                    minQ.pollFirst();

                left++;
            }
            answer = Math.max(answer, right-left+1);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,6,7,8,10,6,5,6};
        System.out.println(longestSubarray(arr, 4));
    }
}
