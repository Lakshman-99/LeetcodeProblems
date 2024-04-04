//  1614. Maximum Nesting Depth of the Parentheses
//
//  https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/

public class Maximum_Nesting_Depth_Of_The_Parentheses {
    public static int maxDepth(String s) {
        int ctr = 0, max = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') ctr++;
            if(c == ')') ctr--;
            if(ctr > max) max = ctr;
        }
        return max;
    }
    public static void main(String[] args) {
        int ans = maxDepth("(1)+((2))+(((3)))");
        System.out.println(ans);
    }
}
