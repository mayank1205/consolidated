import java.util.NoSuchElementException;

public class CustomOptional<T> {
    private final T instance;
    private static final CustomOptional<?> EMPTY =
        new CustomOptional<>(null);

    private CustomOptional(T instance) {
        this.instance = instance;
    }

    public boolean isEmpty() {
        return instance == null;
    }

    public boolean isPresent() {
        return instance != null;
    }

    public T get() {
        if(instance == null) {
            throw new NoSuchElementException();
        }
        return instance;
    }

    public static <T> CustomOptional<T> of(T value) {
        if(value == null) {
            throw new NullPointerException();
        }
        return new CustomOptional<T>(value);
    }

    public static <T> CustomOptional<?> ofNullable(T value) {
        if(value == null) {
            return empty();
        }
        return new CustomOptional<T>(value);
    }

    public static <T> CustomOptional<?> empty() {
        return EMPTY;
    }
    
}
