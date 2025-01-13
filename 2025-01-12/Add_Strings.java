// 415. Add Strings

// https://leetcode.com/problems/add-strings/description

public class Add_Strings {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;

        while(n1 >= 0 || n2 >= 0 || carry > 0) {
            int N1 = n1 >= 0 ? num1.charAt(n1--) - '0' : 0;
            int N2 = n2 >= 0 ? num2.charAt(n2--) - '0' : 0;

            int sum = N1 + N2 + carry;
            sb.append(sum % 10);

            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String s1 = "6";
        String s2 = "501";
        System.out.println(addStrings(s1, s2));
    }
}
