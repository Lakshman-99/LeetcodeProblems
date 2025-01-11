//  43. Multiply Strings
//
//  https://leetcode.com/problems/multiply-strings/description/

public class Multiply_Strings {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length();
        int m = num2.length();
        int max = Math.max(n, m);
        StringBuilder[] result = new StringBuilder[max];
        max = 0;
        int ptr = 0;
        StringBuilder sb;

        for(int i=m-1;i>=0;i--) {
            sb = new StringBuilder();
            int x = num2.charAt(i) - '0';
            int c = 0;

            sb.append("0".repeat(Math.max(0, m - 1 - i)));

            for(int j=n-1;j>=0;j--) {
                int y = num1.charAt(j) - '0';
                y = (x * y) + c;
                c = y/10;
                sb.append(y%10);
            }
            if(c != 0) sb.append(c);
            result[ptr++] = sb;
            max = Math.max(max, sb.length());
        }
        sb = new StringBuilder();
        int c = 0;
        for(int i=0;i<max;i++) {
            int sum = 0;
            for (StringBuilder str : result) {
                if(str != null && i<str.length())
                    sum += str.charAt(i) - '0';
            }
            sum+=c;
            c = sum/10;
            sb.append(sum%10);
        }
        if(c != 0) sb.append(c);

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String ans = multiply("9", "98");
        System.out.println(ans);
    }
}
