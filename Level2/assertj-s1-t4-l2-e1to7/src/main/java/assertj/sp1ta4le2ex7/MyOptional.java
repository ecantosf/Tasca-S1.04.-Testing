package assertj.sp1ta4le2ex7;

import java.util.NoSuchElementException;

public class MyOptional<T> {

    private final T value;
    private static final MyOptional<?> EMPTY = new MyOptional<>(null);
    private MyOptional(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public static <T> MyOptional<T> empty() {
        return (MyOptional<T>) EMPTY;
    }

    public static <T> MyOptional<T> ofNullable(T value) {
        return new MyOptional<>(value);
    }
    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        return new MyOptional<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }
}
