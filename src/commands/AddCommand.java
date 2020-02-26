package commands;

import Collection.CollectionShellInterface;
import MovieClasses.Movie;
import factories.MovieFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command  {
    private CollectionShellInterface T;
    AddCommand(CollectionShellInterface T, CommandFetch cf){
        this.T=T;
        cf.addCommand("add",this);
    }

    @Override
    public void execute(ArrayList<String> str) throws IOException {
        T.add(new MovieFactory().createMovie(str));
    }
}
