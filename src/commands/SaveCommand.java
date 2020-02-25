package commands;

import Collection.CollectionShellInterface;

import Parsers.Parser;
import ReadWriteSome.ReadWrite;
import factories.IDFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SaveCommand implements Command{
    ReadWrite writer;
    IDFactory id;
    CollectionShellInterface cal;
    public SaveCommand(ReadWrite writer,IDFactory id, CommandFetch cf){
        cf.addCommand("save", this);
        this.id=id;
        this.writer=writer;
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        writer.write();
        id.write(String.valueOf(IDFactory.getCurrentID()));
    }
}
