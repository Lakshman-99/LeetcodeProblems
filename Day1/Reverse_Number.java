//  7. Reverse Integer
//
//  https://leetcode.com/problems/reverse-integer/description/

public class Reverse_Number {
    public static int reverse(int x) {
        int ans = 0;
        while(x != 0) {
            if(ans < Integer.MIN_VALUE/10 || ans> Integer.MAX_VALUE/10) return 0;
            int y = x%10;
            ans = ans*10 + y;
            x/=10;
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = reverse(1234567);
        System.out.println(ans);
    }
}
