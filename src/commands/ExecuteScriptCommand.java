package commands;

import Collection.CollectionShellInterface;
import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.*;

public class ExecuteScriptCommand implements Command {
    private CommandFetch cf;
    private BufferedReader scan;
    private CollectionShellInterface cal;

    ExecuteScriptCommand(CommandFetch cf, CollectionShellInterface cal) {
        this.cf = cf;
        this.cal = cal;
        cf.addCommand("execute", this);
    }

    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) throws IOException {
        try {
            File file = new File(T.get(1));
            FileReader fileReader = new FileReader(file);
            scan = new BufferedReader(fileReader);
            String i = scan.readLine().trim();
            while(scan.ready()) {
                while (i.isEmpty()) {
                    i = scan.readLine().trim();
                }
                    cf.run(i,scan);
                    i = "";
                }
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла блин");
        }catch (NullPointerException e){
            System.out.println("Скрипт неоч, давай по новой");
        }

    }
}
