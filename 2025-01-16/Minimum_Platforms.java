import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Platforms {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int ans = 0, a = 0, d = 0, c =0, n = arr.length;

        while(a < n && d < n) {
            if(arr[a] <= dep[d]) {
                c++;
                a++;
                ans = Math.max(ans, c);
            }
            else {
                c--;
                d++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] arr2 = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.print(findPlatform(arr, arr2));
    }
}
