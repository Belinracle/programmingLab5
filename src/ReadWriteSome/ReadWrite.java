package ReadWriteSome;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReadWrite {
    void read() throws FileNotFoundException;
    void write() throws IOException;
}
