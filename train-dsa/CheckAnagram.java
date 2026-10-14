import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class CheckAnagram {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();

        List<Number> numbers = integers;
        String first = "mayank";
        String second = "aynamk";

        if (first.length() != second.length()) {
            System.out.println("Not an anagram");
            return;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(i);

            map.put(firstChar, map.getOrDefault(firstChar, 0) + 1);
            map.put(secondChar, map.getOrDefault(secondChar, 0) - 1);
        }

        boolean isAnagram = true;
        for (int count : map.values()) {
            System.out.println(count);
            if (count != 0) {
                isAnagram = false;
                break;
            }
        }

        System.out.println(isAnagram ? "is anagram" : "Not anagram");
    }
}
