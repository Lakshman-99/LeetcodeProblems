//  6. Zigzag Conversion
//
//  https://leetcode.com/problems/zigzag-conversion/description/

public class Zigzag_Conversion {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        int len = s.length();
        int step = 2*(numRows - 1);
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            for(int j=i;j<len;j+=step) {
                ans.append(s.charAt(j));
                if(i>0 && i<numRows-1 && j+step-2*i < len) {
                    ans.append(s.charAt(j+step-2*i));
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String ans = convert("PAYPALISHIRING", 4);
        System.out.println(ans);
    }
}
