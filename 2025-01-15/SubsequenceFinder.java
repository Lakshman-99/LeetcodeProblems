public class SubsequenceFinder {

    public static int findSubsequence(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return 0; // Return an empty array if there are less than 3 elements
        }

        // Step 1: Create left_min array
        int[] left_min = new int[n];
        left_min[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left_min[i] = Math.min(left_min[i - 1], arr[i - 1]);
        }

        // Step 2: Create right_max array
        int[] right_max = new int[n];
        right_max[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], arr[i + 1]);
        }

        // Step 3: Find the subsequence
        int c = 0;
        for (int j = 1; j < n - 1; j++) {
            if (left_min[j] < arr[j] && arr[j] < right_max[j]) {
                c++; // Valid subsequence
            }
        }

        // If no subsequence is found, return an empty array
        return c;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 3, 7, 8, 10, 20}; // Example input
        int result = findSubsequence(arr);

        System.out.println(result);
    }
}
