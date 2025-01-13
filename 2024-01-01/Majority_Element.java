import java.util.*;
public class Majority_Element {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        int ans = 0;

        for(int num:nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
            if(hm.get(num) > max) {
                max = hm.get(num);
                ans = num;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(ans);
    }
}
