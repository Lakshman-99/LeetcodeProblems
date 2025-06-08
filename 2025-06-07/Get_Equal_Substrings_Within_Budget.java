package patterns.sliding_window;

public class Get_Equal_Substrings_Within_Budget {
    public static int equalSubstring(String s, String t, int maxCost) {
        int answer = 0, left = 0, cost = 0;
        for(int right=0;right<s.length();right++) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            while(cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            answer = Math.max(answer, right-left+1);
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "acde", 0));
    }
}
