public class Arranging_Coins {
    public static int arrangeCoins(int n) {
        int sum = n;
        for(int i=1;i<=n;i++) {
            if(sum-i < 0)
                return i-1;

            sum -= i;
        }
        return 1;
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1));
    }
}
