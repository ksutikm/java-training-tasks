public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        HelloWord helloWord = (HelloWord) container.createInstance(HelloWord.class);
    }
}
