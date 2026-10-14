import java.util.function.Supplier;

public class CustomOptional<T> {
    private final T value;

    public CustomOptional(T value) {
        this.value = value;
    }

    public T get() {
        if (value == null) {
            throw new IllegalStateException("Value is not present");
        }
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }

    public T orElseGet(Supplier<T> supplier) {
        return value != null ? value : supplier.get();
    }

    public boolean isEmpty() {
        return value == null;
    }

    public static <T> CustomOptional<T> of(T value) {
        if(value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        return new CustomOptional<T>(value);
    }

    public static <T> CustomOptional<T> empty() {
        return new CustomOptional<>(null);
    }
    
}
