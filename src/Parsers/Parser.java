package Parsers;

import java.io.IOException;

/**
 * Интерфейс для работы различных парсеров
 */
public interface Parser {
    String ser ();
    void deSer(String path) throws IOException;
}
