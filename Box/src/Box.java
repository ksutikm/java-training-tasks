public class Box<T> {
    private final int boxSize;
    private int currentSize;
    private BaseBox<T>[] box;

    public Box(int boxSize) {
        this.boxSize = boxSize;
        currentSize = 0;
        box = new BaseBox[boxSize];
    }

    public void put(T element) throws Exception {
        if (currentSize == boxSize)
            throw new Exception("Box is full!");
        BaseBox<T> object = new BaseBox<>(element);
        box[currentSize++] = object;
    }

    public <T> T get() throws Exception {
        if (currentSize == 0)
            throw new Exception("Box is empty!");
        int randomIndex = (int) (Math.random() * (currentSize - 1));
        BaseBox<T> result = (BaseBox<T>) box[randomIndex];
        return result.getObject();
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
        box[currentSize--] = null;
    }
}
