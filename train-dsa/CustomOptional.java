public class CustomOptional<T> {

    private T value;

    public CustomOptional(T value) {
        this.value = value;
    }

    public boolean isPresent() {
        if(this.value == null) {
            return false;
        }
        return true;
    }

    public T get() {
        if(this.value == null) {
            throw new IllegalStateException("Value is not present");
        }
        return this.value;
    }

    public boolean isEmpty() {
        return this.value == null;
    }
    
}
