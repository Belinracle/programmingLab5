package commands;

import Collection.CollectionShellInterface;
import MovieClasses.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command {
    private CollectionShellInterface T;
    public ShowCommand(CollectionShellInterface T, CommandFetch cf){
        this.T=T;
        cf.addCommand("show",this);
    }
    @Override
    public void execute(ArrayList<String> A) {
        T.show();
    }
}
