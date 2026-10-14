import java.util.NoSuchElementException;

public final class CustomOptional<T> {

    private final T value;

    private static final CustomOptional<?> EMPTY =
            new CustomOptional<>(null);

    private CustomOptional(T value) {
        this.value = value;
    }

    public static <T> CustomOptional<T> of(T value) {

        if (value == null) {
            throw new NullPointerException(
                    "Value cannot be null");
        }

        return new CustomOptional<>(value);
    }

    public static <T> CustomOptional<T> ofNullable(T value) {

        if (value == null) {
            return empty();
        }

        return new CustomOptional<>(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> CustomOptional<T> empty() {
        return (CustomOptional<T>) EMPTY;
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T get() {

        if (value == null) {
            throw new NoSuchElementException(
                    "No value present");
        }

        return value;
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }

    @Override
    public String toString() {
        return value != null
                ? "CustomOptional[" + value + "]"
                : "CustomOptional.empty";
    }
}