import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Container {
    public <T> T createInstance(Class<T> clazz) throws IllegalArgumentException {
        if (clazz.isAnnotationPresent(ControlledObject.class)){
            System.out.println("create instance ; name  -  " + clazz.getAnnotation(ControlledObject.class));
        } else {
            throw new IllegalArgumentException("Class is not annotated");
        }

        Method method = getInitMethod(clazz);
        T obj = null;

        try {
            obj = clazz.newInstance();
            method.invoke(obj);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        return obj;
    }

    private <T> Method getInitMethod(Class<T> clazz) {
        List<Method> methods = Arrays.stream(clazz.getMethods())
                .filter(value -> value.isAnnotationPresent(StartObject.class))
                .collect(Collectors.toList());
        if (methods.size() > 1) {
            throw new IllegalArgumentException("This class must have one method with StartObject annotation");
        }
        return methods.get(0);
    }
}
