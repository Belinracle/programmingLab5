package commands;

import Collection.CollectionShellInterface;
import MovieClasses.Movie;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command {
    private CollectionShellInterface T;
    ShowCommand(CollectionShellInterface T, CommandFetch cf){
        this.T=T;
        cf.addCommand("show",this);
    }
    @Override
    public void execute(ArrayList<String> A, BufferedReader reader) {
        T.show();
    }
}
