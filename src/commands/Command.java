package commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface  Command {
    public void execute(ArrayList<String> T) throws IOException;
}
