package patterns.two_pointers;

import java.util.Arrays;

public class Duplicate_Zeros {
    public static void duplicateZeros(int[] arr) {
        if(arr == null || arr.length == 0) return;

        int n = arr.length;
        int zeros = 0;
        for(int num : arr)
            if(num == 0)
                zeros++;

        int left = n-1, right = n+zeros-1;
        while(left >= 0) {
            if(right < n) {
                arr[right] = arr[left];
            }

            if(arr[left] == 0) {
                if (right - 1 < n) {
                    arr[right - 1] = 0;
                }
                right--;
            }

            right--;
            left--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0,6};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
