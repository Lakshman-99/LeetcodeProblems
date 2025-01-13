public class Longest_Subarray_With_Given_Sum_K {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int left = 0, right = 0, max = 0, sum = A[0];
        while(right < N) {
            while(left <= right && sum > K) {
                sum -= A[left++];
            }
            if(sum == K) {
                max = Math.max(max, right - left + 1);
            }
            if(++right < N) {
                sum += A[right];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = new int[]{10, 5, 2, 7, 1, 9};
        System.out.println(lenOfLongSubarr(a, 6, 15));
    }
}
