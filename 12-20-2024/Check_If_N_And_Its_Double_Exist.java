// 1346. Check If N and Its Double Exist

// https://leetcode.com/problems/check-if-n-and-its-double-exist/description

import java.util.HashSet;

public class Check_If_N_And_Its_Double_Exist {
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr) {
            if((num%2==0 && set.contains(num/2)) || set.contains(num*2))
                return true;
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        boolean ans = checkIfExist(new int[]{3,1,7,11});
        System.out.println(ans);
    }
}
