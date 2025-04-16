import java.util.Arrays;
import java.util.Random;

public class Random_Pick_With_Weight {
    public int[] prefix;
    public int totalSum;
    public Random rand;
    public Random_Pick_With_Weight(int[] w) {
        int n = w.length;
        prefix = w;

        for(int i=1;i<n;i++) {
            prefix[i] += prefix[i-1];
        }
        totalSum = prefix[n-1];
        rand = new Random();
    }

    public int pickIndex() {
        int target = rand.nextInt(totalSum)+1;

        int left = 0, right = prefix.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(prefix[mid] == target) {
                return mid;
            }
            if(target < prefix[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
    public static void main(String[] args) {
        Random_Pick_With_Weight solution1 = new Random_Pick_With_Weight(new int[]{1});
        System.out.println(solution1.pickIndex());  // Expected output: 0

        // Example 2:
        Random_Pick_With_Weight solution2 = new Random_Pick_With_Weight(new int[]{1, 3});
        System.out.println(solution2.pickIndex());  // Random output: 1 or 0 based on probability
        System.out.println(solution2.pickIndex());  // Random output: 1 or 0 based on probability
        System.out.println(solution2.pickIndex());  // Random output: 1 or 0 based on probability
        System.out.println(solution2.pickIndex());  // Random output: 1 or 0 based on probability
        System.out.println(solution2.pickIndex());  // Random output: 1 or 0 based on probability
    }
}
