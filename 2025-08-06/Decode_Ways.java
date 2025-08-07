package patterns.dynamic_programming;

import java.util.*;

public class Decode_Ways {
    public static int solve(String s, int cur, int[] cache) {
        if(cur == s.length()) return 1;
        if(s.charAt(cur) == '0') return 0;
        if(cache[cur] != -1) return cache[cur];

        cache[cur] = solve(s, cur+1, cache);
        if(cur + 1 < s.length() && (s.charAt(cur) == '1' || (s.charAt(cur) == '2' && s.charAt(cur+1) <= '6'))) {
            cache[cur] += solve(s, cur+2, cache);
        }

        return cache[cur];
    }
    public static int numDecodings(String s) {
        int[] cache = new int[s.length()+1];
        Arrays.fill(cache, -1);

        return solve(s, 0, cache);
    }
    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecodings(s));
    }
}
