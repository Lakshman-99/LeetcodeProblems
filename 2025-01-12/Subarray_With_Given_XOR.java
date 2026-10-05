// https://www.interviewbit.com/problems/subarray-with-given-xor/

import java.util.HashMap;

public class Subarray_With_Given_XOR {
    public static int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int xor = 0, ans = 0;
        for (int a : A) {
            xor ^= a;

            if (map.containsKey(xor ^ B)) {
                ans += map.get(xor ^ B);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        System.out.println(solve(arr, 6));
    }
}
