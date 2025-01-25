// 215. Kth Largest Element in an Array

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.PriorityQueue;

public class Kth_Largest_Element {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums) {
            heap.offer(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
    }
}
