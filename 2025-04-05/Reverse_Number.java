package amazon;

public class Reverse_Number {
    public static int reverse(int x) {
        int ans = 0;

        while(x != 0) {
            if(ans > Integer.MAX_VALUE/10 || ans < Integer.MIN_VALUE/10) return 0;
            ans = ans*10 + x%10;
            x/=10;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
