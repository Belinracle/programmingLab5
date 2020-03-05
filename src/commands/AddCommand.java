package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * команда добавления к коллекции элемента
 */
public class AddCommand implements Command  {
    private CollectionShellInterface T;
    AddCommand(CollectionShellInterface T, CommandFetch cf){
        this.T=T;
        cf.addCommand("add",this);
    }

    @Override
    public void execute(ArrayList<String> str, BufferedReader reader) throws IOException {
        try{
        if(reader!=null){
            T.add(new MovieFactory(reader).createMovie(str));
        }
        else {
            T.add(new MovieFactory().createMovie(str));
        }}catch(NullPointerException e){
            System.out.println("скрипт фигня, давай по новой");
        }
    }
}
