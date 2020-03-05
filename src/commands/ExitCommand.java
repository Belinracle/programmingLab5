package commands;



import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExitCommand implements Command {
    ExitCommand(CommandFetch cf){
        cf.addCommand("exit",this);
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) {
        System.exit(0);
    }
}
