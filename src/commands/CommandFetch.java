package commands;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class  CommandFetch {
    private Map<String,Command> commandMap;
    public CommandFetch() throws FileNotFoundException {
        commandMap = new HashMap<>();
        addCommand("Help", new HelpCommand("C:\\Users\\Даниэль\\Desktop\\Лабораторные\\programming\\Lab5\\SomeFile") );
    }
    public void run(String str){
        String[] words = str.split(" ");
        commandMap.get(words[0]).execute(null);
    }
    public void addCommand(String str,Command cmd){
        commandMap.put(str,cmd);
    }
}
