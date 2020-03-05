package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * интерфейс для подключения команд
 */
public interface  Command {
    void execute(ArrayList<String> T, BufferedReader reader) throws IOException;
}
