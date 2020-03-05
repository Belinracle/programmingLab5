package commands;

import Collection.DequeMovieCollection;
import Parsers.Parser;
import ReadWriteSome.FileWorker;
import ReadWriteSome.ReadWrite;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadCommand implements Command{
    private ReadWrite reader;
    private DequeMovieCollection deq;
    LoadCommand(CommandFetch cf, ReadWrite reader, DequeMovieCollection cal){
        this.reader=reader;
        deq=cal;
        cf.addCommand("load",this);
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader j) throws IOException {
        reader.read();
    }
}
