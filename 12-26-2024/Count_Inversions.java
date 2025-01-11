// https://www.naukri.com/code360/problems/count-inversions_615?leftPanelTabValue=PROBLEM

import java.util.ArrayList;

public class Count_Inversions {
    public static long mergeSort(long[] arr, int low, int m, int high) {
        ArrayList<Long> temp = new ArrayList<>();
        int left = low;
        int right = m + 1;

        int cnt = 0;

        while (left <= m && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
                cnt += (m - left + 1);
            }
        }

        while (left <= m)
            temp.add(arr[left++]);

        while (right <= high)
            temp.add(arr[right++]);

        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);

        return cnt;
    }

    public static long merge(long[] arr, int low, int high) {
        long count = 0;
        if(low >= high) return count;

        int m = (low + high) / 2;
        count += merge(arr, low, m);
        count += merge(arr,  m + 1, high);
        count += mergeSort(arr, low, m, high);

        return count;
    }
    public static long getInversions(long[] arr, int n) {
        return merge(arr, 0, n-1);
    }
    public static void main(String[] args) {
        long[] arr1 = new long[]{5,4,3,2,1};
        System.out.println(getInversions(arr1, 5));
    }
}
