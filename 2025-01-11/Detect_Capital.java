// 520. Detect Capital

// https://leetcode.com/problems/detect-capital/description

public class Detect_Capital {
    public static boolean detectCapitalUse(String word) {
        boolean allCaps = true, fst = false, allSmall = true;

        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(c < 65 || c > 90) {
                allCaps = false;
            }
            else if(i == 0) {
                fst = true;
                allSmall = false;
            }
            else if (fst) {
                fst = false;
            }
            else {
                allSmall = false;
            }
        }

        return allCaps || fst || allSmall;
    }
    public static void main(String[] args) {
        String word = "FLAG";
        System.out.println(detectCapitalUse(word));
    }
}
