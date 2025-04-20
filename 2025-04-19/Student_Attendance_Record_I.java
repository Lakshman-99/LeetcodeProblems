public class Student_Attendance_Record_I {
    public static boolean checkRecord(String s) {
        int absent = 0, late = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(c == 'A') {
                absent++;
                if(absent == 2) return false;
            }
            else if(c == 'L') {
                late = i != 0 && c == s.charAt(i-1) ? late+1 : 1;
                if(late == 3) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }
}
