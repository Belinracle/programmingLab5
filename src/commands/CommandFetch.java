package commands;

import Collection.DequeMovieCollection;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class  CommandFetch {
    private Map<String,Command> commandMap;
    public CommandFetch() throws FileNotFoundException {
        commandMap = new HashMap<>();
    }
    public void run(String str){
        ArrayList<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
        System.out.println(words);
        if (words.size()>1){
            commandMap.get(words.get(0)).execute(words);
        }
        commandMap.get(words.get(0)).execute(null);
    }
    public void addCommand(String str,Command cmd){
        commandMap.put(str,cmd);
    }
}
