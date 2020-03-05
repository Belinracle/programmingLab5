package ReadWriteSome;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Интерфейс для работы с данными(записью и чтением)
 */
public interface ReadWrite {
    void read() throws FileNotFoundException;
    void write() throws IOException;
}
