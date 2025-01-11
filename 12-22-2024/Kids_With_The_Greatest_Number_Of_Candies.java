// 1431. Kids With the Greatest Number of Candies

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description

import java.util.ArrayList;
import java.util.List;

public class Kids_With_The_Greatest_Number_Of_Candies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> ans = new ArrayList<>();
        int max = 0;

        for(int i=0;i<candies.length;i++) {
            max = Math.max(max, candies[i]);
            candies[i]+=extraCandies;
        }

        for(int candy : candies)
            ans.add(candy >= max);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1,3};
        System.out.println(kidsWithCandies(arr, 3).toString());
    }
}
