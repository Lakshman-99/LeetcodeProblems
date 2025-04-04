package amazon;

public class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        int strLen = lcp.length();

        for(String str : strs) {
            int len = str.length();
            while(strLen > len || !lcp.equals(str.substring(0, strLen))) {
                strLen--;
                if(strLen < 0) {
                    return "";
                }

                lcp = lcp.substring(0, strLen);
            }
        }

        return lcp;
    }
    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }
}
