import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Container {
    public Object createInstance(Class clazz) throws IllegalArgumentException {
        if (clazz.isAnnotationPresent(ControlledObject.class)){
            System.out.println("create instance ; name  -  " + clazz.getAnnotation(ControlledObject.class));
        } else {
            throw new IllegalArgumentException("Class is not annotated");
        }

        Method method = null;
        List<Method> methods = Arrays.stream(clazz.getMethods())
                .filter(value -> value.isAnnotationPresent(StartObject.class))
                .collect(Collectors.toList());
        if (methods.size() > 1) {
            throw new IllegalArgumentException("This class must have one method with StartObject annotation");
        } else {
            method = methods.get(0);
        }

        try {
            method.invoke(clazz.newInstance());
            return clazz.newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
