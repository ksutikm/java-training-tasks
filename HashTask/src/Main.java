import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User first = new User("Mike","mike@example.com");
        User second = new User("Mike","john@example.com");
        Map<User, String> users = new HashMap<>();
        users.put(first, "first");
        users.put(second, "second");
        User third = new User("Mike","mike@example.com");
        System.out.println(users.get(third));
    }
}
