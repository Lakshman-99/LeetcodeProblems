// Repeat and Missing Number Array

// https://www.interviewbit.com/problems/repeat-and-missing-number-array/

import java.util.Arrays;

public class Repeat_And_Missing_Number_Array {
    public static int[] repeatedNumber(final int[] A) {
        Arrays.sort(A);
        int sum = A[0], expSum = 1, twice = 0;

        for(int i=1;i<A.length;i++) {
            sum+=A[i];
            expSum+=i+1;
            if(A[i-1] == A[i])
                twice = A[i];
        }

        int missing = expSum - (sum - twice);

        return new int[]{twice, missing};
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(repeatedNumber(arr1)));
    }
}
