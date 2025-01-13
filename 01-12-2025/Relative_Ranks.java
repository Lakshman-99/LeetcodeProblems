// 506. Relative Ranks

// https://leetcode.com/problems/relative-ranks/description/?envType=problem-list-v2&envId=array

import java.util.Arrays;
import java.util.HashMap;

public class Relative_Ranks {
    public static String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<score.length;i++)
            map.put(score[i], i);

        Arrays.sort(score);
        int rank = 1;

        for(int i=score.length-1;i>=0;i--) {
            if(i == score.length-1)
                ans[map.get(score[i])] = "Gold Medal";
            else if(i == score.length-2)
                ans[map.get(score[i])] = "Silver Medal";
            else if(i == score.length-3)
                ans[map.get(score[i])] = "Bronze Medal";
            else
                ans[map.get(score[i])] = ""+rank;

            rank++;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
