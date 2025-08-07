package patterns.dynamic_programming;

import java.util.*;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] cache = new int[triangle.size()][triangle.size()];
        for(int[] row : cache)
            Arrays.fill(row, -1);

        for(int i=0;i<)
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));

        System.out.println(minimumTotal(triangle));
    }
}
