package commands;

import Collection.CollectionShellInterface;
import factories.MovieFactory;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateIDCommand implements Command { //TODO исправить работу
    private CommandFetch cf;
    private CollectionShellInterface cal;
    UpdateIDCommand(CommandFetch cf, CollectionShellInterface cal) {
        this.cf= cf;
        this.cal= cal;
        cf.addCommand("update",this);
    }
    @Override
    public void execute(ArrayList<String> T) throws IOException {
        try {
            cal.updateByID(Long.parseLong(T.get(1)));
        }catch(NumberFormatException e){
            System.out.println("Неверный формат ID");
        }
    }
}
