import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomOptional<T> {
    private T instance = null;
    private static final CustomOptional<?> EMPTY = new CustomOptional<>(null);

    private CustomOptional(T instance) {
        this.instance = instance;
    }

    public T get() {

        if(this.instance == null) {
            throw new NoSuchElementException("No value present");
        }
        return instance;

    }

    public boolean isPresent() {
        return this.instance != null;
    }

    public boolean isEmpty() {
        return this.instance == null;
    }

    public static <T> CustomOptional<T> of(T arg) {
        return new CustomOptional<T>(Objects.requireNonNull(arg));
    }

    @SuppressWarnings("unchecked")
    public static <T> CustomOptional<T> ofNullable(T arg) {
        return arg != null
                ? new CustomOptional<>(arg)
                : (CustomOptional<T>) EMPTY;
    }

    @SuppressWarnings("unchecked")
    public static <T> CustomOptional<T> empty() {
        return (CustomOptional<T>) EMPTY;
    }
}
