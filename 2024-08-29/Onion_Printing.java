public class Onion_Printing {
    public static void getNumberPattern(int n) {
        for(int i=1;i<=2*n-1;i++) {
            int t = n;
            for(int j=1;j<=2*n-1;j++) {
                if(i == 1 || i == 2*n-1 || j == 1 || j == 2*n-1) {
                    System.out.print(n);
                    continue;
                }
                if(j<=n) {
                    if(j<=(i>n?n-i%n:i)) t--;
                    System.out.print(t);
                } else {
                    if(j > (i>n?n+i%n:2*n-(i%n==0?n:i%n))) t++;
                    System.out.print(t);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        getNumberPattern(n);
    }
}
