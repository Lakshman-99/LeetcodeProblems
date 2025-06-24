package patterns.two_pointers;

public class Long_Pressed_Name {
    public static boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) return false;

        int p1 = 0, p2 = 0;
        int n1 = name.length(), n2 = typed.length();

        while(p2 < n2) {
            if(p1 < n1 && name.charAt(p1) == typed.charAt(p2)) {
                p1++;
                p2++;
            }
            else if(p2 > 0 && typed.charAt(p2) == typed.charAt(p2-1)) {
                p2++;
            }
            else {
                return false;
            }
        }

        return p1 == n1;
    }
    public static void main(String[] args) {
        System.out.println(isLongPressedName("vtkgn", "vttkgnln"));
    }
}
