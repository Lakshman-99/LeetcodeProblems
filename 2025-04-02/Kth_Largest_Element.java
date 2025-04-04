package amazon;

import java.util.PriorityQueue;

public class Kth_Largest_Element {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr, 4));
    }
}
