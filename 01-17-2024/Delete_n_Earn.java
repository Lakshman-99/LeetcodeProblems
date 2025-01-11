import java.util.*;
public class Delete_n_Earn {
    public static int maxEarn(int n, HashMap<Integer, Integer> hm, ArrayList<Integer> set, int[] dp) {
        if(n == set.size()) {
            return 0;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int take = set.get(n) * hm.get(set.get(n));
        if(n+1 < set.size() && set.get(n+1) == set.get(n) + 1) {
            take += maxEarn(n+2, hm, set, dp);
        }
        else if(n+1 < set.size() && set.get(n+1) != set.get(n) + 1) {
            take += maxEarn(n+1, hm, set, dp);
        }
        int not_take = maxEarn(n+1, hm, set, dp);
        return dp[n] = Math.max(not_take, take);
    }
    public static int deleteAndEarn(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> set = new ArrayList<>(hm.keySet());
        return maxEarn(0, hm, set, dp);
    }
    public static void main(String[] args) {
        int ans = deleteAndEarn(new int[]{2,2,3,3,3,4});
        System.out.println(ans);
    }
}
