import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            CRUDExample.read();
            CRUDExample.add();
            CRUDExample.read();
            CRUDExample.update();
            CRUDExample.read();
            CRUDExample.delete();
            CRUDExample.read();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}