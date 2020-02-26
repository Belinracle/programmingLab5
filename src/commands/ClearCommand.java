package commands;

import Collection.CollectionShellInterface;

import java.io.IOException;
import java.util.ArrayList;

public class ClearCommand implements Command{
    private CollectionShellInterface cal;
    ClearCommand(CollectionShellInterface cal,CommandFetch cf){
        cf.addCommand("clear",this);
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.clear();
    }
}
