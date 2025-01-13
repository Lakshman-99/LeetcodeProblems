//  1992. Find All Groups of Farmland
//
//  https://leetcode.com/problems/find-all-groups-of-farmland/description/

import java.util.*;

public class Find_All_Groups_Of_Farmland {
    public static int rMax;
    public static int cMax;
    public static void dfs(int[][] land, int i, int j) {
        if(i == land.length || j == land[0].length || land[i][j] != 1) return;
        land[i][j] = 0;
        rMax = Math.max(i, rMax);
        cMax = Math.max(j, cMax);
        dfs(land, i, j+1);
        dfs(land, i+1, j);
    }
    public static int[][] findFarmland(int[][] land) {
        rMax = 0;
        cMax = 0;
        int n = land.length;
        int m = land[0].length;
        int c = 0;
        List<int[]> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(land[i][j] == 1) {
                    dfs(land, i, j);
                    ans.add(new int[]{i, j, rMax, cMax});
                    rMax = 0;
                    cMax = 0;
                }
            }
        }

        return ans.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1,0,0},
                {0,1,1},
                {0,1,1}
        };
        int[][] ans = findFarmland(mat);
        for(int[] r : ans)
            System.out.println(Arrays.toString(r));
    }
}
