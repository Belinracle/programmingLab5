package commands;

import Collection.CollectionShellInterface;

import java.io.IOException;
import java.util.ArrayList;

public class InfoCommand implements Command {
    CollectionShellInterface cal;
    public InfoCommand(CommandFetch cf, CollectionShellInterface cal){
        this.cal=cal;
        cf.addCommand("info", this);
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.info();
    }
}
