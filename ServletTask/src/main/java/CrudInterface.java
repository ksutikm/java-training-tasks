public interface CrudInterface<T> {
    public void read();
    public void add(T t);
    public String update(T t, int id);
    public void delete(int id);
}
