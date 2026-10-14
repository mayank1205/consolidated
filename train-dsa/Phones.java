import java.util.List;
import java.util.stream.Stream;

public class Phones {
    public static void main(String[] args) {
        List<List<String>> phones = List.of(
        List.of("111", "222"),
        List.of("333", "444")
        );
        Stream<Stream<String>> result =
        phones.stream()
            .map(List::stream);
        System.out.println(result.toString());
    }
}
