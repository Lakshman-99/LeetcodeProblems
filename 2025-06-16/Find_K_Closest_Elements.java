package patterns.two_pointers;

import java.util.*;

public class Find_K_Closest_Elements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;

        int n = arr.length;
        int left = 0, right = n-1;
        while(right - left >= k) {
            if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        for(int i=left;i<=right;i++)
            result.add(arr[i]);

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findClosestElements(arr, 4, -1));
    }
}
