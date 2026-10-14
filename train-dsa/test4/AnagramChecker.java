import java.util.Map;
import java.util.HashMap;

public class AnagramChecker {
    public static void main(String[] args) {
        if(args.length< 2) {
            System.out.println("Please pass atleast two strings");
            return;
        }
        String first = args[0].toLowerCase();
        String second = args[1].toLowerCase();
        if(first.length() != second.length()) {
            System.out.println("not an anagram");
        }
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i< first.length(); i++) {
            freqMap.put(first.charAt(i), freqMap.getOrDefault(first.charAt(i), 0) + 1);
            freqMap.put(second.charAt(i), freqMap.getOrDefault(second.charAt(i), 0) - 1);
        }

        for (Character ch : freqMap.keySet()) {
            if(freqMap.get(ch) != 0) {
                System.out.println("not an anagram");
                return;
            }
        }
        System.out.println("it is an anagram");
    }
}
