// 1422. Maximum Score After Splitting a String

// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description

public class Maximum_Score_After_Splitting_A_String {
    public static int maxScore(String s) {
        int _0 = 0, _1 = 0, _t1 = 0, ans = 0;

        for(char c : s.toCharArray())
            if(c == '1')
                _t1++;

        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i) == '1')
                _1++;
            else
                _0++;

            int score = _0 + (_t1 - _1);
            ans = Math.max(ans, score);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }
}
