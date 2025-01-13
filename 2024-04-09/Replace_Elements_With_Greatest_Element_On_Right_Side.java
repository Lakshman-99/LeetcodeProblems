//  1299. Replace Elements with Greatest Element on Right Side
//
//  https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

import java.util.*;

public class Replace_Elements_With_Greatest_Element_On_Right_Side {
    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];
        arr[n-1] = -1;

        for(int i=n-2;i>=0;i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] result = replaceElements(new int[]{17,18,5,4,6,1});
        System.out.println(Arrays.toString(result));
    }
}
