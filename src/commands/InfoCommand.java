package commands;

import Collection.CollectionShellInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class InfoCommand implements Command {
    private CollectionShellInterface cal;
    InfoCommand(CommandFetch cf, CollectionShellInterface cal){
        this.cal=cal;
        cf.addCommand("info", this);
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) {
        cal.info();
    }
}
