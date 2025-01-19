import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static List<List<String>> result;
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i<=j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }
    public static void solve(String s, List<String> cur, int ind) {
        if(ind == s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int i=ind;i<s.length();i++) {
            String t = s.substring(ind, i+1);
            if(isPalindrome(t)) {
                cur.add(t);
                solve(s, cur, i+1);
                cur.remove(cur.size()-1);
            }
        }

    }
    public static List<List<String>> partition(String s) {
        result = new ArrayList<>();

        solve(s, new ArrayList<>(), 0);

        return result;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
