import java.util.List;

public interface CrudInterface {
    public void read();
    public void add(Student student);
    public void update(Student student, int id);
    public void delete(int id);
}
