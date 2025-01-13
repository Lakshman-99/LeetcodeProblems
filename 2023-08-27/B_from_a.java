import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
/*
Problem
You are given two strings
and of length and  respectively consisting of lowercase English letters. You can make several strings using characters from . If you use any character of to make the string, that character will be removed from
.
That means if you select an integer
from  to the length of the string  and use , then the character  will be removed and the string length gets reduced by , the indices of characters to the right of the deleted one also get reduced by
.
Find the maximum number of strings you can make the same as that of
.
Sample Input
2
4 3
hgeb
ebh
7 3
xyzxyxx
xyx
Sample Output
1
2
Explanation
For test case1: The first string uses characters at indexes 1, 3, and 4 (1-based indexing). Hence, the answer is 1.
For test case2: The first string uses characters at indexes 1, 2, and 4 (1-based indexing). The second string uses characters at indexes 5, 6, and 7 (1-based indexing). Hence, the answer is 2.
 */
class B_from_a {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner br = new Scanner(System.in);
        int tc = br.nextInt();

        while(tc>0) {
            int n = br.nextInt();
            int m = br.nextInt();
            String s1 = br.next();
            String s2 = br.next();
            HashMap<Character, Integer> str1 = new HashMap<>();
            HashMap<Character, Integer> str2 = new HashMap<>();

            for(int i=0; i<n; i++){
                if(!str1.containsKey(s1.charAt(i)) ) {
                    str1.put(s1.charAt(i), 1);
                }
                else {
                    str1.put(s1.charAt(i), str1.get(s1.charAt(i)) + 1);
                }
            }
            for(int i=0; i<m; i++){
                if(!str2.containsKey(s2.charAt(i)) ) {
                    str2.put(s2.charAt(i), 1);
                }
                else {
                    str2.put(s2.charAt(i), str2.get(s2.charAt(i)) + 1);
                }
            }

            int total = 0, max = Integer.MAX_VALUE;
            Iterator itr = str2.keySet().iterator();
            while(itr.hasNext()) {
                Character c = (Character) itr.next();
                if(str1.containsKey(c)) {
                    int x = str1.get(c) / str2.get(c);
                    if(x < max) {
                        max = x;
                    }
                }
            }
            if (max == Integer.MAX_VALUE) {
                max = 0;
            }
            System.out.println(max);

            tc--;
        }

    }
}
