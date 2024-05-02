//  119. Pascal's Triangle II
//
//  https://leetcode.com/problems/pascals-triangle-ii/description/

import java.util.*;
public class Pascals_Triangle_II {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();

        for(int i=0;i<=rowIndex;i++) {
            List<Integer> cur = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) cur.add(1);
                else {
                    cur.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev = cur;
        }

        return prev;
    }

    public static void main(String[] args) {
        List<Integer> ans = getRow(3);
        System.out.println(ans.toString());
    }
}
