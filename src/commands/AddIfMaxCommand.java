package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.io.IOException;
import java.util.ArrayList;

public class AddIfMaxCommand implements Command {
    private CollectionShellInterface cal;
    AddIfMaxCommand(CollectionShellInterface cal, CommandFetch cf){
        this.cal=cal;
        cf.addCommand("add_if_max",this);
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.addIfMax(new MovieFactory().createMovie(T));
    }
}
