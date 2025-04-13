public class Find_Closest_Person {
    public static int findClosest(int x, int y, int z) {
        int diff1 = Math.abs(z-x);
        int diff2 = Math.abs(z-y);

        return diff1 == diff2 ? 0 : diff1 < diff2 ? 1 : 2;
    }
    public static void main(String[] args) {
        System.out.println(findClosest(1,5,3));
    }
}
