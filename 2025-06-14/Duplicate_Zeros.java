package patterns.two_pointers;

import java.util.Arrays;

public class Duplicate_Zeros {
    public static void duplicateZeros(int[] arr) {
        if(arr == null || arr.length == 0) return;

        int n = arr.length;
        int duplicates = 0, i = 0;
        while(duplicates < n && i < n) {
            if(arr[i] == 0) duplicates++;
            i++;
            duplicates++;
        }

        duplicates -= i;
        int left = n-1-duplicates, right = n-1;
        while(left >= 0) {
            if(arr[left] != 0) {
                arr[right] = arr[left];
            }
            else {
                arr[right--] = 0;
                arr[right] = 0;
            }

            right--;
            left--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {8,4,5,0,0,0,0,7};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
