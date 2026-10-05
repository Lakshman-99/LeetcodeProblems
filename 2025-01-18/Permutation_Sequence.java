package practice;

import java.util.ArrayList;

public class Permutation_Sequence {
    public static String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while(true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if (numbers.isEmpty())
                break;

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }
}