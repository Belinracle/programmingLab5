import Collection.DequeMovieCollection;
import MovieClasses.Movie;
import commands.AddCommand;
import commands.Command;
import commands.CommandFetch;
import commands.InfoCommand;
import factories.MovieFactory;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        CommandFetch cf = new CommandFetch();
        DequeMovieCollection dequeMovieCollection = new DequeMovieCollection();
        Command add = new AddCommand(dequeMovieCollection, cf);
        Command info = new InfoCommand(dequeMovieCollection, cf);
        while(true) {
            cf.run(scan.nextLine());
        }

    }
}
