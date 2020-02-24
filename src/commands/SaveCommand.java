package commands;

import Collection.CollectionShellInterface;
import WorkWithFile.FileWorker;
import WorkWithFile.Parser;
import factories.IDFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SaveCommand implements Command{
    Parser parser;
    FileWorker ID;
    CollectionShellInterface cal;
    public SaveCommand(Parser parser , FileWorker ID, CommandFetch cf, CollectionShellInterface cal){
        cf.addCommand("save", this);
        this.ID=ID;
        this.parser=parser;
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.save(parser, ID);
        ID.write(String.valueOf(IDFactory.getCurrentID()));
    }
}
