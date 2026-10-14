import java.util.Map;
import java.util.HashMap;

public class CheckAnagram {
    public static void main(String[] args) {
        String str1 = "Sil1ent";
        String str2 = "Listen";

        System.out.println(checkIfItsAnagram(str1,str2));
    }

    private static String checkIfItsAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() != str2.length()) {
            return "Not an Anagram";
        }
        Map<Character, Integer> frequencyMap = new HashMap();
        for(int i = 0; i<str1.length() ; i++) {
            frequencyMap.put(str1.charAt(i),
                frequencyMap.getOrDefault(str1.charAt(i), 0) + 1);
            frequencyMap.put(str2.charAt(i),
                frequencyMap.getOrDefault(str2.charAt(i), 0) - 1);
        }
        for (char character : frequencyMap.keySet()) {
            if(frequencyMap.get(character) != 0) return "It is not an Anagram";
        }
        return "It's an Anagram";
    }
}
