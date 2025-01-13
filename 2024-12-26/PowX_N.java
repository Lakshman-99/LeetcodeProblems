public class PowX_N {
    public static double myPow(double x, int n) {
        double ans = 1;
        long N = n < 0 ? -1 * (long) n : n;

        while(N > 0) {
            if(N % 2 == 1) {
                ans *= x;
                N--;
            }
            else {
                x *= x;
                N /= 2;
            }
        }

        return n < 0  ? 1.0 / ans : ans;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;

        System.out.println(myPow(x, n));
    }
}
