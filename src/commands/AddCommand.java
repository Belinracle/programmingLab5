package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command  {
    private CollectionShellInterface T;
    public AddCommand(CollectionShellInterface T,CommandFetch cf){
        this.T=T;
        cf.addCommand("Add",this);
    }

    @Override
    public void execute(ArrayList<String> str) {
        T.add(new MovieFactory(str).createMovie());
    }
}
