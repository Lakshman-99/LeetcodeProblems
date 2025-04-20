import java.util.*;

public class Make_Array_Non_decreasing {
    public static int maximumPossibleSize(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (result.isEmpty() || num >= result.get(result.size() - 1)) {
                result.add(num);
            }
        }

        return result.size();
    }
    public static void main(String[] args) {
        System.out.println(maximumPossibleSize(new int[]{19,80,63,74}));
    }
}
