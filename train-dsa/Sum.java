import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sum {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5);
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        System.out.println(numbers.stream().reduce(0, Integer::max));
        System.out.println(numbers.stream().reduce(0, Integer::min));
        System.out.println(numbers.stream().filter(n->n%2!=0).toList());
        numbers.stream().collect(Collectors.toMap(n->n, Function.identity()));
    }
}