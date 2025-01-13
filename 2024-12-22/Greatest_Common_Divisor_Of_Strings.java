// 1071. Greatest Common Divisor of Strings
// https://leetcode.com/problems/greatest-common-divisor-of-strings/description

public class Greatest_Common_Divisor_Of_Strings {
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int n = str1.length(), m = str2.length();
        while(m != 0) {
            int temp = n % m;
            n = m;
            m= temp;
        }

        return str1.substring(0, n);
    }
    public static void main(String[] args) {
        String s1 = "LEET";
        String s2 = "CODE";
        System.out.println(gcdOfStrings(s1, s2));
    }
}
