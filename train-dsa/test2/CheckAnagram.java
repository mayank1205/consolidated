import java.util.Map;
import java.util.HashMap;

public class CheckAnagram {
    public static void main(String[] args) {
        String first = "l1isten";
        String second = "silent";
        System.out.println(checkAnagram(first, second));
    }

	private static String checkAnagram(String first, String second) {
		Map<Character, Integer> freq = new HashMap<>();
        if(first.length() != second.length()){
            return "not an anagram";
        }
        for(int i =0;i<first.length(); i++) {
            freq.put(first.charAt(i), freq.getOrDefault(first.charAt(i), 0) + 1);
            freq.put(second.charAt(i), freq.getOrDefault(second.charAt(i), 0) - 1);
        }
        for(Character key : freq.keySet()) {
            if(freq.get(key) != 0) {
                return "not an anagram";
            }
        }
        return "it is anagram";
	}
}
