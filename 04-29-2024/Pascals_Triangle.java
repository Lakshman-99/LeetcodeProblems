//  118. Pascal's Triangle
//
//  https://leetcode.com/problems/pascals-triangle/description/

import java.util.*;

public class Pascals_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            List<Integer> curRow = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) curRow.add(1);
                else curRow.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(curRow);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = generate(5);
        System.out.println(ans.toString());
    }
}
