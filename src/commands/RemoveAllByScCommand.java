package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;
import factories.MoviePersonFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class RemoveAllByScCommand implements Command {
    private CollectionShellInterface cal;
    RemoveAllByScCommand(CollectionShellInterface cal,CommandFetch cf){
        cf.addCommand("remove_all_by_screenwriter",this);
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) throws IOException {
        try {
            if (reader != null) {
                cal.removeAllBySc(new MoviePersonFactory(reader).createMoviePerson());
            } else {
                cal.removeAllBySc(new MoviePersonFactory().createMoviePerson());
            }
        }catch(NullPointerException e){
            System.out.println("скрипт фигня, давай по новой");
        }
    }
}
