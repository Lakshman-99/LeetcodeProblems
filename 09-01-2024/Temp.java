import java.util.*;

public class Temp {
    public static String str;

    public static boolean hasDuplicate(List<Integer> num) {
        int[] freq = new int[10];
        for(Integer i : num) {
            if(freq[i] != 0) return true;
            freq[i]++;
        }
        return false;
    }
    public static void solve(List<Integer> nums, int ind, int k, List<Integer> store) {
        if(ind == nums.size()) {
            if(store.size() == k && !hasDuplicate(store)) {
                StringBuilder s = new StringBuilder();
                for(Integer i : store) {
                    s.append(i);
                }
                str = str.replace(s.toString(), "");
            }
            return;
        }
        store.add(nums.get(ind));
        solve(nums, ind+1, k, store);
        store.remove(store.size()-1);
        solve(nums, ind+1, k, store);
    }
    public static String partitionArray(int k, List<Integer> numbers) {
        StringBuilder newS = new StringBuilder();
        for(Integer num : numbers) {
            newS.append(num);
        }
        str = newS.toString();
        solve(numbers, 0, k, new ArrayList<>());
        return str.isEmpty() ? "YES" : "NO";
    }
    public static int[][] print2largest(int[] original, int m, int n) {
        // Code Here
        int len = original.length;
        if(len != m*n) return new int[0][];
        int[][] arr = new int[m][n];
        int c = -1, e = 0;
        int[] temp = new int[n];
        for(int i=0;i<len;i++) {
            temp[++c] = original[i];
            if(c+1 == n && e <= m) {
                arr[e++] = temp;
                temp = new int[n];
                c=-1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        List<Integer> q = Arrays.asList(3,2,3,4);
//        String resp = partitionArray(2, q);
//        System.out.println(resp);
        int[] arr = new int[]{1};
        int[][] a = print2largest(arr,1,2);

        for(int[] b : a) {
            System.out.println(Arrays.toString(b));
        }
    }
}
