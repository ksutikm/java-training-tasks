public interface CrudInterface {
    public String read();
    public void add(Student student);
    public void update(Student student, int id);
    public void delete(int id);
}
