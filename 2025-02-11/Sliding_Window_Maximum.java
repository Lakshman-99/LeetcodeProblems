import java.util.*;

public class Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            while(!q.isEmpty() && q.peekFirst() <= i-k)
                q.pollFirst();

            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();

            q.offerLast(i);
            if(i >= k-1) {
                ans[i-k+1] = nums[q.peekFirst()];
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }
}
