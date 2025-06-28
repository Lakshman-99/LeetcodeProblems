package patterns.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Find_K_th_Smallest_Pair_Distance {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        List<Integer> arr = new ArrayList<>();
        for(int i=1;i<nums.length;i++) {
            arr.add(nums[i]-nums[i-1]);
        }

        Collections.sort(arr);
        return arr.get(k > arr.size() ? k % arr.size() : k - 1);
    }
    public static void main(String[] args) {
        int[] arr = {9,10,7,10,6,1,5,4,9,8};
        System.out.println(smallestDistancePair(arr, 18));
    }
}
