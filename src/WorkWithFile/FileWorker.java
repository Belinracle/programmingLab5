package WorkWithFile;

import java.io.FileNotFoundException;

public interface FileWorker {
    String read();
    void write(String str) throws FileNotFoundException;
}
