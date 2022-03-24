import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;

public class Two {
    public static void main(String[] args) throws Exception {
        URL classLoaderURL = Paths.get("C:/Users/k.tsipileva/compiles/").toUri().toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{classLoaderURL});
        Class<?> clazz = Class.forName("One", true, urlClassLoader);
        Method method = clazz.getMethod("printString", String.class);
        Object object = clazz.getDeclaredConstructor().newInstance();
        method.invoke(object, "This is string");
    }
}
