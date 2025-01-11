import java.util.ArrayList;
import java.util.Arrays;

public class Generate_Paranthesis {
    public static void generate(int open, int close, int n, String s, ArrayList<String> ans){
        if(s.length() == 2*n) {
            ans.add(s);
            return ;
        }
        if(open < n) {
            generate(open+1, close, n, s+"(", ans);
        }
        if(close< n && close < open) {
            generate(open, close+1, n, s+")", ans);
        }
    }
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        generate(0, 0, 3, "", ans);
        System.out.println(ans);
    }
}
