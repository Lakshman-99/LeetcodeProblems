public class Compare_Version_Numbers {
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
        int ans = compareVersion("1.2", "1.10");
        System.out.println(ans);
    }
}
