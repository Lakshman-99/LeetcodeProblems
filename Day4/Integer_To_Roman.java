//  12. Integer to Roman
//
//  https://leetcode.com/problems/integer-to-roman/description/

public class Integer_To_Roman {
    public static final String[] STRING = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static final int[] CHECK = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<CHECK.length;i++) {
            while(num>=CHECK[i]) {
                num-=CHECK[i];
                ans.append(STRING[i]);
            }
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        String ans = intToRoman(59);
        System.out.println(ans);
    }
}
