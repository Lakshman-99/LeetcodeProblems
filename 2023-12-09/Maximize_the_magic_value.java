import java.util.HashSet;
import java.util.Scanner;

public class Maximize_the_magic_value {
    public static void main(String args[]) throws Exception {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc > 0) {
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();

            for(int i=0; i<n; i++) {
                set.add(sc.nextInt()) ;
            }
            System.out.println(set.size());
            tc--;
        }
    }
}