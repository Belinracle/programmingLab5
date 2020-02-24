package commands;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelpCommand implements Command {
    private Scanner sc;
    public HelpCommand(CommandFetch cf, String path) throws IOException {//TODO не дергать каждый раз файл
        File myFile = new File(path);
        sc = new Scanner(new FileReader(path));
        cf.addCommand("help",this);
    }
    @Override
    public void execute(ArrayList<String> T) {
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }
}
