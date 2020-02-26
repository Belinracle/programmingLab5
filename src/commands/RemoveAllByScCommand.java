package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;
import factories.MoviePersonFactory;

import java.io.IOException;
import java.util.ArrayList;

public class RemoveAllByScCommand implements Command {
    CollectionShellInterface cal;
    RemoveAllByScCommand(CollectionShellInterface cal,CommandFetch cf){
        cf.addCommand("remove_all_by_screenwriter",this);
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.removeAllBySc(new MoviePersonFactory().createMoviePerson());
    }
}
