import  java.util.*;
public class Contains_duplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            if (hs.contains(num)) {
                return true;
            }
            hs.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean bool = containsDuplicate(new int[]{3,2,4});
        System.out.print(bool);
    }
}
