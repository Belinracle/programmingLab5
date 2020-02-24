package commands;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelpCommand implements Command {
    private BufferedReader reader;
    String help;
    public HelpCommand(CommandFetch cf, String path) throws IOException {//TODO не дергать каждый раз файл
        File myFile = new File(path);
        reader = new BufferedReader(new FileReader(path));
        help="";
        while(reader.ready()) {
            help=help +"\n"+reader.readLine();
        }
        cf.addCommand("help",this);
    }
    @Override
    public void execute(ArrayList<String> T) {
            System.out.println(help);
        }
    }

