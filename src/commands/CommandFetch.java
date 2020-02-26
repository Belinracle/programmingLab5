package commands;

import Collection.DequeMovieCollection;
import Exceptions.Exit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class  CommandFetch {
    private Map<String,Command> commandMap;
    public CommandFetch()  {
        commandMap = new HashMap<>();
    }
    void run(String str) throws IOException {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
        words.removeAll(Collections.singleton(""));
            if (words.size() > 1) {
                commandMap.get(words.get(0).toLowerCase()).execute(words);
                return;
            }
            commandMap.get(words.get(0).toLowerCase()).execute(null);
    }
    public void addCommand(String str,Command cmd){
        commandMap.put(str,cmd);
    }
}
