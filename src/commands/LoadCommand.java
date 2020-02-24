package commands;

import Collection.DequeMovieCollection;
import WorkWithFile.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class LoadCommand implements Command{
    Parser parser;
    DequeMovieCollection deq;
    public LoadCommand(CommandFetch cf, Parser parser, DequeMovieCollection cal){
        this.parser=parser;
        deq=cal;
        cf.addCommand("load",this);
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        parser.load(deq.getCal());
    }
}
