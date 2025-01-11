// 412. Fizz Buzz

// https://leetcode.com/problems/fizz-buzz/description

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for(int i=1;i<=n;i++) {
            if(i%5==0 && i%3==0) ans.add("FizzBuzz");
            else if(i%5==0) ans.add("Buzz");
            else if(i%3==0) ans.add("Fizz");
            else ans.add(i+"");
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fizzBuzz(5));
    }
}
