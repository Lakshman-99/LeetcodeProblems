import java.util.*;
public class Unique_Number_of_Occurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        return hm.size() == new HashSet<>(hm.values()).size();
    }
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
