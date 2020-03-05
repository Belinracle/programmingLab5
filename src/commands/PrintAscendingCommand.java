package commands;

import Collection.CollectionShellInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class PrintAscendingCommand implements Command {
    private CollectionShellInterface cal;
    PrintAscendingCommand(CollectionShellInterface cal, CommandFetch cf){
        cf.addCommand("print_ascending",this);
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reaeder){
        cal.printAscending();
    }
}
