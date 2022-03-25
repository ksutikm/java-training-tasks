public class BaseBox<T> {
    private T object;

    public BaseBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
