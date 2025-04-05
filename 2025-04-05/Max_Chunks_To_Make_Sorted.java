package amazon;

public class Max_Chunks_To_Make_Sorted {
    public static int maxChunksToSorted(int[] arr) {
        int result = 1, max = arr[0];

        for(int i=0;i<arr.length-1;i++) {
            if(arr[i] > arr[i+1] || max > arr[i+1]) {
                max = Math.max(max, arr[i]);
                continue;
            }

            result++;
            max = arr[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,0,1};
        System.out.println(maxChunksToSorted(arr));
    }
}
