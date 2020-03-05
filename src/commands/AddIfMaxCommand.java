package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddIfMaxCommand implements Command {
    private CollectionShellInterface cal;
    AddIfMaxCommand(CollectionShellInterface cal, CommandFetch cf){
        this.cal=cal;
        cf.addCommand("add_if_max",this);
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) throws IOException {
        try {
            if (reader != null) {
                cal.addIfMax(new MovieFactory(reader).createMovie(T));
            } else {
                cal.addIfMax(new MovieFactory().createMovie(T));
            }
        }catch(NullPointerException e){
            System.out.println("скрипт фигня, давай по новой");
        }
    }
}
