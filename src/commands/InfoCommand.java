package commands;

import Collection.CollectionShellInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InfoCommand implements Command {
    private CollectionShellInterface T;
    public InfoCommand(CollectionShellInterface T,CommandFetch cf){
        this.T=T;
        cf.addCommand("Info",this);
    }
    @Override
    public void execute(ArrayList<String> A) {
        System.out.println(T.toString());
    }
}
