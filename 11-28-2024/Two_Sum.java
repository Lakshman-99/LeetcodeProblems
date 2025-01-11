package practice;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public static int[] twoSum(int[] arr, int tar) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ind = 0;

        for(Integer i : arr) {
            if(hm.containsKey(tar - i)) {
                return new int[]{hm.get(tar-i), ind};
            }
            hm.put(i, ind);
            ind++;
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int tar = 9;

        System.out.println(Arrays.toString(twoSum(arr, tar)));
    }
}
