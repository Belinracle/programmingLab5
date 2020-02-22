package commands;

import Collection.DequeMovieCollection;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  CommandFetch {
    private Map<String,Command> commandMap;
    public CommandFetch() throws FileNotFoundException {
        commandMap = new HashMap<>();
    }
    public void run(String str){
        List<String> words = Arrays.asList(str.split(" "));
        System.out.println(words);
        commandMap.get(words.get(0)).execute(null);
    }
    public void addCommand(String str,Command cmd){
        commandMap.put(str,cmd);
    }
}
