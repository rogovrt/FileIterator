import java.io.*;
import java.util.NoSuchElementException;

public class FileIterator {
    private BufferedReader buf;

    public FileIterator(String path) {
        try {
            FileReader fr = new FileReader(path);
            buf = new BufferedReader(fr);
        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public boolean hasNext() {
        try {
            buf.mark(1);
            String s = buf.readLine();
            buf.reset();
            return (s != null);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String next() {
        if (this.hasNext()) {
            try {
                return buf.readLine();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        throw new NoSuchElementException();
    }
}
