public class Compare_Version_Numbers {
    public static int compareVersion2(String version1, String version2) {
        int i=0, j=0;

        while(i < version1.length() || j < version2.length()) {
            int num1 = 0, num2 = 0;
            while(i < version1.length() && version1.charAt(i) != '.')
                num1 = num1*10 + (version1.charAt(i++) - '0');

            while(j < version2.length() && version2.charAt(j) != '.')
                num2 = num2*10 + (version2.charAt(j++) - '0');

            if(num1 < num2)
                return -1;

            if(num1 > num2)
                return 1;

            i++;
            j++;
        }

        return 0;
    }
    public static int compareVersion(String version1, String version2) {
        String [] s1=version1.split("\\.");
        String [] s2=version2.split("\\.");
        int length = Math.max(version1.length(), version2.length());
        for(int i=0;i<length;i++){
            int num1 = i<s1.length ? Integer.parseInt(s1[i]) :0;
            int num2 = i<s2.length ? Integer.parseInt(s2[i]) :0;
            if(num1>num2){
                return 1;
            }
            if(num1<num2){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int ans = compareVersion2("1.2", "1.10");
        System.out.println(ans);
    }
}
