package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Класс хранящий экземпляры команд в HashMap для быстрого и легкого доступа к командам и их выполнению
 */
public class  CommandFetch {
    private Map<String,Command> commandMap;
    private Thread hook;
    public CommandFetch()  {
        commandMap = new HashMap<>();
        hook = new Thread(() -> System.out.println("Работа программы прервана. Изменения не сохранены"));
        Runtime.getRuntime().addShutdownHook(hook);
    }
    void run(String str, BufferedReader reader) throws IOException {
        try {
            ArrayList<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
            words.removeAll(Collections.singleton(""));
            if(words.get(0).equals("exit")){
                Runtime.getRuntime().removeShutdownHook(hook);
            }
            commandMap.get(words.get(0).toLowerCase()).execute(words,reader);
        } catch (NoSuchElementException | IndexOutOfBoundsException |NullPointerException e) {
            System.out.println("Неизвестная команда");
        }
    }
    public void addCommand(String str,Command cmd){
        commandMap.put(str,cmd);
    }
}
