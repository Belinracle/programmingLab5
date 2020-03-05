package commands;

import Collection.CollectionShellInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Remove_by_idCommand implements Command{
    private CollectionShellInterface cal;
    Remove_by_idCommand(CommandFetch cf, CollectionShellInterface cal){
        cf.addCommand("remove_by_id",this);
        this.cal=cal;
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) {
        try {
            cal.removeByID(Long.parseLong(T.get(1)));
        }catch(NumberFormatException e){
            System.out.println("Неверный формат введенного ID");
        }
    }
}
