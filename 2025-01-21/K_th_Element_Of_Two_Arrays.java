// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

public class K_th_Element_Of_Two_Arrays {
    public static int kthElement(int a[], int b[], int k) {
        int e1=a.length, e2=b.length;
        if(e2 > e1) return kthElement(b, a, k);

        int low = Math.max(0, k - e2);
        int high = Math.min(k, e1);
        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < e1) r1 = a[mid1];
            if (mid2 < e2) r2 = b[mid2];
            if (mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = b[mid2 - 1];

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if(l1 > r2) {
                high = mid1 - 1;
            }
            else
                low = mid1 + 1;

        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};

        System.out.println(kthElement(arr, arr2, 5));
    }
}
