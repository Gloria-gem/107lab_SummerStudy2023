import java.io.IOException;

public class IOUTest1 {
    public static void main(String[] args) {
        try {
            IOUtil.printHex("D:\\11.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
