import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Fractional_Knapsack {
    public static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        int[][] sack = new int[n][2];

        for(int i=0;i<n;i++)
            sack[i] = new int[]{val.get(i), wt.get(i)};

        Arrays.sort(sack, (a, b) -> Double.compare((double) b[0] /b[1], (double) a[0] /a[1]));
        double ans = 0.0;

        for(int i=0;i<n;i++) {
            if(capacity >= sack[i][1]) {
                capacity -= sack[i][1];
                ans += sack[i][0];
            }
            else {
                ans += (((double) sack[i][0] / sack[i][1]) * capacity);
                break;
            }
        }

        return (double) Math.round(ans * 1_000_000) / 1_000_000.0;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(8, 2, 10, 1, 9, 7, 2, 6, 4, 9));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(10, 1, 7, 7, 5, 1, 8, 6, 8, 7));

        System.out.println(fractionalKnapsack(arr1, arr2, 21));
    }
}
