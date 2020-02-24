package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateIDCommand implements Command { //TODO исправить работу
    CommandFetch cf;
    CollectionShellInterface cal;
    MovieFactory mf;
    public UpdateIDCommand(CommandFetch cf, CollectionShellInterface cal) throws IOException {
        this.cf= cf;
        this.cal= cal;
        cf.addCommand("update",this);
        mf=new MovieFactory();
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.updateByID(Long.parseLong(T.get(1)),mf);
    }
}
