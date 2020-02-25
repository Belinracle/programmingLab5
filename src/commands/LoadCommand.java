package commands;

import Collection.DequeMovieCollection;
import Parsers.Parser;
import ReadWriteSome.FileWorker;
import ReadWriteSome.ReadWrite;

import java.io.IOException;
import java.util.ArrayList;

public class LoadCommand implements Command{
    ReadWrite reader;
    DequeMovieCollection deq;
    public LoadCommand(CommandFetch cf, ReadWrite reader, DequeMovieCollection cal){
        this.reader=reader;
        deq=cal;
        cf.addCommand("load",this);
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        reader.read();
    }
}
