//  38. Count and Say
//
//  https://leetcode.com/problems/count-and-say/description/

public class Count_And_Say {
    public static String count(StringBuilder str, int n) {
        if(n==1) return str.append(1).toString();
        str = new StringBuilder(count(str, n-1));
        int ctr = 1, i;
        StringBuilder ans = new StringBuilder();
        str.append("#");  // For Convenience
        for(i=1;i<str.length();i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                ctr++;
            }
            else {
                ans.append(ctr).append(str.charAt(i-1));
                ctr = 1;
            }
        }
        if(ctr != 1) {
            ans.append(ctr).append(str.charAt(i-1));
        }
        return ans.toString();
    }
    public static  String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        return count(ans, n);
    }
    public static void main(String[] args) {
        String ans = countAndSay(4);
        System.out.println(ans);
    }
}
