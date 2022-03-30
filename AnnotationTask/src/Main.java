public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        HelloWord helloWord = container.createInstance(HelloWord.class);
    }
}
