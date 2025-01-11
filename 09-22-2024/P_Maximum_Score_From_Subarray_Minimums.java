import java.util.*;

public class P_Maximum_Score_From_Subarray_Minimums {
    public static int pairWithMaxSum(List<Integer> arr) {
        int max = 0, t;

        for(int i=1;i<arr.size();i++) {
            t = arr.get(i-1) + arr.get(i);
            if(t > max) {
                max = t;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 3, 1, 5, 6);
        System.out.println(pairWithMaxSum(arr));
    }
}
