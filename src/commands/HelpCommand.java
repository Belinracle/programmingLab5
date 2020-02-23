package commands;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class HelpCommand implements Command {
    private Scanner sc;
    public HelpCommand(String path) throws FileNotFoundException {
        super();
        File file = new File(path);
        sc = new Scanner(file);
    }
    @Override
    public void execute(ArrayList<String> T) {
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
