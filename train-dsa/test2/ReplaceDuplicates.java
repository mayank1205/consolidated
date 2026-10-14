import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class ReplaceDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 2, 5};
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< arr.length; i++) {
            if(!set.add(arr[i])) {
                arr[i] = -1;
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
