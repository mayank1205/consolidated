import java.util.HashSet;
import java.util.Set;

public class ReplaceDuplicate {
/*
Replace duplicate numbers with -1 in the array
 {5, 3, 2, 8, 2, 5}
*/    

    static int[] arr = {5, 3, 2, 8, 2, 5};
    static int[] index = new int[9];

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i< arr.length; i++) {
            if(!set.add(arr[i])) {
                arr[arr[i]] = -1;
            }
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
