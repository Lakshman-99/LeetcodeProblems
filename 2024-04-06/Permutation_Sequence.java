//  60. Permutation Sequence
//
//  https://leetcode.com/problems/permutation-sequence/
import java.util.*;

public class Permutation_Sequence {
    public static String getPermutation(int n, int k) {
        List<Integer> nums=new LinkedList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact*=i;
            nums.add(i);
        }
        nums.add(n);
        k--;
        StringBuilder ans = new StringBuilder();

        while(true){
            int ind = k/fact;
            ans.append(nums.remove(ind));
            if(nums.isEmpty()) break;

            k = k%fact;
            fact = fact/nums.size();
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        String ans = getPermutation(3, 5);
        System.out.println(ans);
    }
}
