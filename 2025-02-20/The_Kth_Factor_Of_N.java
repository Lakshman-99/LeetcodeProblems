public class The_Kth_Factor_Of_N {
    public static int kthFactor(int n, int k) {
        for(int i=1;i<=n;i++) {
            if(n%i == 0) --k;
            if(k == 0) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(kthFactor(4, 4));
    }
}
