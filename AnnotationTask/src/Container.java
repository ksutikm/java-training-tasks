import java.lang.reflect.*;

public class Container {
    public Object doSomething(Class clazz) {
        if (clazz.isAnnotationPresent(ControlledObject.class)){
            System.out.println("Class annotated");
        } else {
            System.err.println("Class is not annotation!");
        }

        Method[] methods = clazz.getMethods();
        if (methods.length != 1) {
            System.err.println("This class must have one method!");
        }
        Method method = methods[0];

        if (method.isAnnotationPresent(StartObject.class)) {
            System.out.println("Method annotated");
        } else {
            System.err.println("Method is not annotation!");
        }

        Object object = null;

        try {
            object = clazz.newInstance();
            method.invoke(clazz);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return object;
    }
}
