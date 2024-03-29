import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Box<T> {
    private final int boxSize;
    private int currentSize;
    private List<T> box;

    public Box(int boxSize) {
        this.boxSize = boxSize;
        currentSize = 0;
        box = new ArrayList<>(boxSize);
    }

    public void put(T element) throws Exception {
        if (currentSize == boxSize)
            throw new Exception("Box is full!");
        box.add(element);
        currentSize++;
    }

    public <T> T get() throws Exception {
        if (currentSize == 0)
            throw new Exception("Box is empty!");
        int randomIndex = (int) (Math.random() * (currentSize - 1));
        return (T) box.get(randomIndex);
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public void remove(T element) throws Exception {
        if (currentSize == 0)
            throw new Exception("Box is empty!");
        box.remove(currentSize--);
    }

    public List<T> getAll(Predicate<? super T> predicate) {
        return box.stream().filter(predicate).collect(Collectors.toList());
    }

    public void putAll(List<? extends T> list) {
        box.addAll(list);
    }
}
