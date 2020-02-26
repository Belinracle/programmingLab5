package commands;

import Collection.CollectionShellInterface;

import java.io.IOException;
import java.util.ArrayList;

public class RemoveFirstComman implements Command {
    private CollectionShellInterface cal;
    RemoveFirstComman(CollectionShellInterface cal, CommandFetch cf){
        cf.addCommand("remove_first",this);
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T){
        cal.removeFirst();
    }
}
