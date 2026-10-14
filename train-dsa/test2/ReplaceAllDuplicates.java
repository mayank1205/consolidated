import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class ReplaceAllDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 2, 5};
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if(freqMap.get(arr[i]) > 1) {
                arr[i] = -1;
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
