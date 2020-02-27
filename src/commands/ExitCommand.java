package commands;



import java.io.IOException;
import java.util.ArrayList;

public class ExitCommand implements Command {
    ExitCommand(CommandFetch cf){
        cf.addCommand("exit",this);
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        System.exit(0);
    }
}
