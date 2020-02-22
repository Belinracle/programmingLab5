package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

public class AddCommand implements Command  {
    private CollectionShellInterface T;
    public AddCommand(CollectionShellInterface T,CommandFetch cf){
        this.T=T;
        cf.addCommand("Add",this);
    }

    @Override
    public void execute(String str) {
        T.add(new MovieFactory().createMovie());
    }
}
