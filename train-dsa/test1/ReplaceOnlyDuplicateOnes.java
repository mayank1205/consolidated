import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ReplaceOnlyDuplicateOnes {
    static int[] arr = new int[]{5, 3, 2, 8, 2, 5};
    
    public static void main(String[] args) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(seen.contains(arr[i])) {
                arr[i] = -1;
            } else {
                seen.add(arr[i]);
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
