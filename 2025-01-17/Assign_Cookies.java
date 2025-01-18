// 455. Assign Cookies

// https://leetcode.com/problems/assign-cookies/description

import java.util.Arrays;

public class Assign_Cookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0, r = 0, ans = 0;

        while(l < g.length && r < s.length) {
            if(g[l++] <= s[r++])
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] c = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(c,s));
    }

}
