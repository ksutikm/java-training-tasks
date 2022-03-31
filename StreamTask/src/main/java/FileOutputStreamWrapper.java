import java.io.*;

public class FileOutputStreamWrapper extends FileOutputStream {
    private FileOutputStream original;

    public FileOutputStreamWrapper(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileOutputStream.toString());
        this.original = fileOutputStream;
    }

    public void write(byte[] bytes) throws IOException {
        original.write(bytes);
    }

    public void flush() throws IOException {
        original.flush();
    }

    public void close() throws IOException {
        original.flush();
        original.write("File is Closed".getBytes());
        original.close();
    }
}
