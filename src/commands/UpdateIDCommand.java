package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateIDCommand implements Command {
    private CommandFetch cf;
    private CollectionShellInterface cal;
    UpdateIDCommand(CommandFetch cf, CollectionShellInterface cal) {
        this.cf= cf;
        this.cal= cal;
        cf.addCommand("update",this);
    }
    @Override
    public void execute(ArrayList<String> T, BufferedReader reader) throws IOException {
        try {
            cal.updateByID(Long.parseLong(T.get(1)),reader);
        }catch(NumberFormatException e){
            System.out.println("Неверный формат ID");
        }
    }
}
