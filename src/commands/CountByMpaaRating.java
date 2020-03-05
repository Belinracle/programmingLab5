package commands;

import Collection.CollectionShellInterface;
import MovieClasses.MpaaRating;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountByMpaaRating implements Command {
    private CollectionShellInterface cal;
    CountByMpaaRating(CollectionShellInterface cal, CommandFetch cf){
        cf.addCommand("count_by_mpaa_rating",this);
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader scan){
        try {
            cal.countByMpaaRating(MpaaRating.valueOf(T.get(1)));
        }catch(IllegalArgumentException e){
            System.out.println("Введенное вами значение MpaaRating недопустимо. Вот список допустимых"+
                    "\n"+"G" +"\n" +"PG_13"+"\n"+"R"+"\n"+"NC_17");
        }
    }

}
