package patterns.dynamic_programming;

import java.util.*;

public class Triangle {
    public static int solve(int lvl, int idx, List<List<Integer>> triangle, Integer[][] cache) {
        if(cache[lvl][idx] != null) return cache[lvl][idx];

        int path = triangle.get(lvl).get(idx);
        if(lvl < triangle.size()-1) {
            path += Math.min(solve(lvl+1, idx, triangle, cache), solve(lvl+1, idx+1, triangle, cache));
        }

        return cache[lvl][idx] = path;
    }
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] cache = new Integer[n][n];

        return solve(0, 0, triangle, cache);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] cache = new int[n+1][n+1];

        for(int lvl=n-1;lvl>=0;lvl--) {
            for(int idx=0;idx<=lvl;idx++) {
                cache[lvl][idx] = triangle.get(lvl).get(idx) + Math.min(cache[lvl+1][idx], cache[lvl+1][idx+1]);
            }
        }

        return cache[0][0];
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
