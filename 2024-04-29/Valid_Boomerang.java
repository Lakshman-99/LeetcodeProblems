//  1037. Valid Boomerang
//
//  https://leetcode.com/problems/valid-boomerang/description/

public class Valid_Boomerang {
    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        return (x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)) != 0;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0,0},
                {1,1},
                {1,1}
        };
        System.out.println(isBoomerang(mat));
    }
}
