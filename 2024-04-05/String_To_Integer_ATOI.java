//  8. String to Integer (atoi)
//
//  https://leetcode.com/problems/string-to-integer-atoi/description/

public class String_To_Integer_ATOI {
    public static int myAtoi(String s) {
        s = s.trim();
        boolean neg = false;
        long ans = 0;
        int i=0;
        for(char c : s.toCharArray()) {
            if(i==0 && (c=='-' || c=='+')) {
                neg = c=='-';
                i++;
                continue;
            }
            i++;
            if(c-'0' >=0 && c-'0'<=9) {
                if(!neg && ans*10 + (c-'0') >= Integer.MAX_VALUE) {
                    ans = Integer.MAX_VALUE;
                    break;
                }
                if(neg && -1*(ans*10 + (c-'0')) < Integer.MIN_VALUE) {
                    ans = -1L *Integer.MIN_VALUE;
                    break;
                }
                ans = ans*10 + (c-'0');
            } else {
                break;
            }
        }
        return neg ? (int)(-1*ans) : (int)ans;
    }
    public static void main(String[] args) {
        int ans = myAtoi("-4193 with words");
        System.out.println(ans);
    }
}
