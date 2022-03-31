import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/test.txt");
            FileOutputStreamWrapper outputStream = new FileOutputStreamWrapper(fileOutputStream);

            String str = new StringBuilder()
                    .append("So close no matter how far").append("\n")
                    .append("Couldn't be much more from the heart").append("\n")
                    .append("Forever trusting who we are").append("\n")
                    .append("And nothing else matters").append("\n")
                    .toString();

            outputStream.write(str.getBytes());

            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
