package commands;

import Collection.CollectionShellInterface;

import java.io.IOException;
import java.util.ArrayList;

public class Remove_by_idCommand implements Command{
    private CollectionShellInterface cal;
    Remove_by_idCommand(CommandFetch cf, CollectionShellInterface cal){
        cf.addCommand("remove_by_id",this);
    }
    @Override
    public void execute(ArrayList<String> T) {
        try {
            cal.removeByID(Long.parseLong(T.get(1)));
        }catch(NumberFormatException e){
            System.out.println("Неверный формат введенного ID");
        }
    }
}
