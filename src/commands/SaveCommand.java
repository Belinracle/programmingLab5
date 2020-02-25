package commands;

import Collection.CollectionShellInterface;

import WorkWithFile.ID;
import WorkWithFile.Parser;
import factories.IDFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SaveCommand implements Command{
    Parser parser;
    ID id;
    CollectionShellInterface cal;
    public SaveCommand(Parser parser , ID id, CommandFetch cf, CollectionShellInterface cal){
        cf.addCommand("save", this);
        this.id=id;
        this.parser=parser;
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        cal.save(parser);
        id.write(String.valueOf(IDFactory.getCurrentID()));
    }
}
