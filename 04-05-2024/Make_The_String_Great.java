//  1544. Make The String Great
//
//  https://leetcode.com/problems/make-the-string-great/description

public class Make_The_String_Great {
    public static String makeGood(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        int ind = 1;
        int n = s.length();
        for(int i=1;i<n;i++) {
            int ch = s.charAt(i);
            if(ind-1 >= 0 && (ch+32 == ans.charAt(ind-1) || ch == ans.charAt(ind-1)+32)) {
                ans.deleteCharAt(ind-1);
                ind--;
            } else {
                ans.append(s.charAt(i));
                ind++;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String ans = makeGood("leEeetcode");
        System.out.println(ans);
    }
}
