import java.util.*;

public class Find_A_Safe_Walk_Through_A_Grid {
    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();

        grid.add(Arrays.asList(0, 1, 0, 0, 0));
        grid.add(Arrays.asList(0, 1, 0, 1, 0));
        grid.add(Arrays.asList(0, 0, 0, 1, 0));

        System.out.println(findSafeWalk(grid, 1));
    }
}
