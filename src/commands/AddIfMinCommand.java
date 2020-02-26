package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.io.IOException;
import java.util.ArrayList;

public class AddIfMinCommand implements Command {
    private CollectionShellInterface cal;

    AddIfMinCommand(CollectionShellInterface cal, CommandFetch cf) {
        this.cal = cal;
        cf.addCommand("add_if_min", this);
    }

    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.addIfMin(new MovieFactory().createMovie(T));
    }
}
