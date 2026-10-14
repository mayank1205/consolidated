import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class ReplaceDuplicatewithMinusOne {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 2, 5};

        Map<Integer,Integer> frequencyMap = new HashMap();
        for (int num : arr) {
            frequencyMap.put(num,
                frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if(frequencyMap.get(arr[i]) > 1) {
                arr[i] = -1;
            }
        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        
    }
}
