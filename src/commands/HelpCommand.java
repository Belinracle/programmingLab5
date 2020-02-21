package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelpCommand implements Command {
    private Scanner sc;
    public HelpCommand(String path) throws FileNotFoundException {
        super();
        File file = new File(path);
        sc = new Scanner(file);
    }
    @Override
    public void execute(String str) {
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
