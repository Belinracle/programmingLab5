package commands;

import Collection.CollectionShellInterface;

import Parsers.Parser;
import ReadWriteSome.FileWorker;
import ReadWriteSome.ReadWrite;
import factories.IDFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCommand implements Command{
    private IDFactory id;
    private CollectionShellInterface cal;
    SaveCommand(IDFactory id, CommandFetch cf, CollectionShellInterface cal){
        cf.addCommand("save", this);
        this.id=id;
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) throws IOException {
        new FileWorker("Save.txt",cal).write();
        id.write(String.valueOf(IDFactory.getCurrentID()));
    }
}
