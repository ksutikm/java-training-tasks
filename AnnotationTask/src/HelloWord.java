@ControlledObject(name = "hello world")
public class HelloWord {
    @StartObject
    public void printString() {
        System.out.println("Hello, World!");
    }
}
