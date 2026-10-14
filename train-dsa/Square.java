import java.util.ArrayList;
import java.util.List;

public class Square {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        System.out.println(numbers.stream().map(n -> n*n).toList());
    }
}
