public class Swap_Adjacent_In_LR_String {
    public static boolean canTransform(String start, String result) {
        int si = 0, ri = 0, n = start.length();

        while(si < n || ri < n) {
            while(si < n && start.charAt(si) == 'X') si++;
            while(ri < n && result.charAt(ri) == 'X') ri++;

            if(si == n || ri == n) break;

            if (start.charAt(si) != result.charAt(ri)) return false;
            if(start.charAt(si) == 'R' && si > ri) return false;
            if(start.charAt(si) == 'L' && si < ri) return false;

            si++;
            ri++;
        }

        return si == n && ri == n;
    }
    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
}
