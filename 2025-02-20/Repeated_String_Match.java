public class Repeated_String_Match {
    public static int repeatedStringMatch(String a, String b) {
        if(b.isEmpty()) return 0;
        if(a.contains(b)) return 1;

        int stInd = 0, n = a.length(), m = b.length(), i=0;
        while(stInd < n && a.charAt(stInd) != b.charAt(0))
            stInd++;

        while(i<m) {
            if(a.charAt(stInd++ % n) != b.charAt(i++))
                return -1;
        }

        return (int) Math.ceil((double) stInd / n);
    }
    public static void main(String[] args) {
        String a = "abc";
        String b = "xyz";
        System.out.println(repeatedStringMatch(a,b));
    }
}
