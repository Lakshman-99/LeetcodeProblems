//  514. Freedom Trail
//
//  https://leetcode.com/problems/freedom-trail/description

import java.util.*;
class Freedom_Trail {
    public static Map<String, Integer> cache = new HashMap<>();

    public static int findRotateSteps(String ring, String key) {
        return helper(ring, key, 0, 0);
    }

    private static int helper(String ring, String key, int r, int k) {
        if (k == key.length())
            return 0;
        String keyCache = r + "," + k;
        if (cache.containsKey(keyCache))
            return cache.get(keyCache);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(k)) {
                int minDist = Math.min(Math.abs(r - i), ring.length() - Math.abs(r - i));
                int steps = minDist + 1 + helper(ring, key, i, k + 1);
                res = Math.min(res, steps);
            }
        }

        cache.put(keyCache, res);
        return res;
    }

    public static void main(String[] args) {
        int ans = findRotateSteps("godding", "gd");
        System.out.println(ans);
    }
}